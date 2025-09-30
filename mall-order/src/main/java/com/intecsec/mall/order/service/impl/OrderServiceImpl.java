package com.intecsec.mall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.item.dto.ItemDTO;
import com.intecsec.mall.item.dto.ItemSkuDTO;
import com.intecsec.mall.order.client.ItemClient;
import com.intecsec.mall.order.client.UserClient;
import com.intecsec.mall.order.constant.OrderStatusEnum;
import com.intecsec.mall.order.dto.*;
import com.intecsec.mall.order.entity.Order;
import com.intecsec.mall.order.entity.OrderConsignee;
import com.intecsec.mall.order.entity.OrderItem;
import com.intecsec.mall.order.mapper.OrderConsigneeMapper;
import com.intecsec.mall.order.mapper.OrderItemMapper;
import com.intecsec.mall.order.mapper.OrderMapper;
import com.intecsec.mall.order.service.OrderService;
import com.intecsec.mall.order.util.OrderUtil;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-11-26 19:30
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private UserClient userClient;

    @Resource
    private ItemClient itemClient;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderConsigneeMapper orderConsigneeMapper;

    @Override
    public OrderDTO addOrder(AddOrderDTO addOrderDTO) {
        ApiResponse<UserConsigneeDTO> userConsigneeResponse = userClient.getUserConsignee(addOrderDTO.getConsignee_id());
        UserConsigneeDTO userConsigneeDTO = userConsigneeResponse.getData();

        OrderConsigneeDTO orderConsigneeDTO = convertOrderConsigneeDTO(userConsigneeDTO);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(addOrderDTO.getUser_id());

        List<Long> itemIds = new ArrayList<>();
        Map<Long, Integer> itemSkuNumberMap = new HashMap<>();
        for(AddOrderItemDTO addOrderItemDTO : addOrderDTO.getOrder_item_list()) {
            itemIds.add(addOrderItemDTO.getSku_id());
            itemSkuNumberMap.put(addOrderItemDTO.getSku_id(), addOrderItemDTO.getNumber());
        }

        ApiResponse<List<ItemSkuDTO>> itemResponse = itemClient.skuListByIds(StringUtils.join(itemIds, ","));
        List<ItemSkuDTO> itemSkuDTOS = itemResponse.getData();

        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        long orderPriceAmount = 0L;
        for(ItemSkuDTO itemSkuDTO : itemSkuDTOS) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setSkuId(itemSkuDTO.getId());
            orderItemDTO.setItemId(itemSkuDTO.getItemId());
            orderItemDTO.setSkuNum(itemSkuNumberMap.get(itemSkuDTO.getId()));
            orderItemDTO.setSkuPrice(itemSkuDTO.getSkuPrice());
            orderItemDTO.setSkuName(itemSkuDTO.getSkuName());

            orderPriceAmount += itemSkuDTO.getSkuPrice();

            orderItemDTOS.add(orderItemDTO);
        }

        orderDTO.setOrderConsignee(orderConsigneeDTO);
        orderDTO.setOrderItemList(orderItemDTOS);
        orderDTO.setPriceAmount(orderPriceAmount);
        orderDTO.setDeleteMark((byte)0);
        orderDTO.setCouponAmount(0L);
        orderDTO.setPointAmount(0L);
        orderDTO.setDiscountAmount(0L);
        orderDTO.setDeliveryFee(0L);
        orderDTO.setPayAmount(orderDTO.getPriceAmount() - orderDTO.getDiscountAmount() + orderDTO.getDeliveryFee());

        OrderDTO returnOrderDTO = addOrderToDB(orderDTO);
        return returnOrderDTO;
    }

    @Transactional(rollbackFor = {Exception.class})
    // @GlobalTransactional
    public OrderDTO addOrderToDB(OrderDTO orderDTO) {
        Order order = DOUtils.copy(orderDTO, Order.class);
        order.setOrderStatus(OrderStatusEnum.UN_PAID.getOrderStatus());

        OrderConsignee orderConsignee = DOUtils.copy(orderDTO.getOrderConsignee(), OrderConsignee.class);

        order.setOrderSn(OrderUtil.genOrderSn());
        long row = orderMapper.insert(order);
        log.info("insert rows:{}", row);
        long orderId = order.getId();

        orderConsignee.setOrderId(orderId);
        orderConsigneeMapper.insert(orderConsignee);

        List<OrderItem> orderItems = DOUtils.copyList(orderDTO.getOrderItemList(), OrderItem.class);
        for(OrderItem orderItem : orderItems) {
            orderItem.setOrderId(orderId);
            orderItemMapper.insert(orderItem);
        }

        orderDTO.setId(orderId);
        orderDTO.setOrderSn(order.getOrderSn());

        return getOrder(orderId);
    }

    private OrderConsigneeDTO convertOrderConsigneeDTO(UserConsigneeDTO userConsigneeDTO) {
        OrderConsigneeDTO orderConsigneeDTO = new OrderConsigneeDTO();
        orderConsigneeDTO.setUserId(userConsigneeDTO.getUserId());
        orderConsigneeDTO.setConsigneeName(userConsigneeDTO.getConsigneeName());
        orderConsigneeDTO.setMobile(userConsigneeDTO.getMobile());
        orderConsigneeDTO.setProvince(userConsigneeDTO.getProvince());
        orderConsigneeDTO.setCity(userConsigneeDTO.getCity());
        orderConsigneeDTO.setArea(userConsigneeDTO.getArea());
        orderConsigneeDTO.setAddress(userConsigneeDTO.getAddress());
        return orderConsigneeDTO;
    }

    private void decOneOrderConsignee(OrderDTO orderDTO) {
        QueryWrapper<OrderConsignee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderDTO.getId());
        OrderConsignee orderConsignee = orderConsigneeMapper.selectOne(queryWrapper);
        OrderConsigneeDTO orderConsigneeDTO = DOUtils.copy(orderConsignee, OrderConsigneeDTO.class);
        orderDTO.setOrderConsignee(orderConsigneeDTO);
    }

    private Map<Long, List<OrderItemDTO>> getOrderItemMap(List<OrderItem> orderItems) {
        List<OrderItemDTO> orderItemDTOS = DOUtils.copyList(orderItems, OrderItemDTO.class);
        if(CollectionUtils.isEmpty(orderItems)) {
            return new HashMap<>();
        }
        Map<Long, List<OrderItemDTO>> orderItemMap = new HashMap<>();
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            if (!orderItemMap.containsKey(orderItemDTO.getOrderId())) {
                orderItemMap.put(orderItemDTO.getOrderId(), new ArrayList<>());
            }
            orderItemMap.get(orderItemDTO.getOrderId()).add(orderItemDTO);
        }
        return  orderItemMap;
    }

    @Override
    public OrderDTO getOrder(long id) {
        Order order = orderMapper.selectById(id);
        OrderDTO orderDTO = DOUtils.copy(order, OrderDTO.class);

        decOneOrderItems(orderDTO);

        decOneOrderConsignee(orderDTO);

        return orderDTO;
    }

    private void decOneOrderItems(OrderDTO orderDTO) {
        QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderDTO.getId());
        List<OrderItem> orderItems = orderItemMapper.selectList(queryWrapper);
        Map<Long, List<OrderItemDTO>> orderItemMap = getOrderItemMap(orderItems);
        orderDTO.setOrderItemList(orderItemMap.get(orderDTO.getId()));
    }

    @Override
    public List<OrderDTO> getOrderList(int page, int pageSize) {
        Page<Order> orderPage = new Page<>(page, pageSize);
        Page<Order> orderPageResult = orderMapper.selectPage(orderPage, null);
        List<Order> orderList = orderPageResult.getRecords();
        return DOUtils.copyList(orderList, OrderDTO.class);
    }

    @Override
    public OrderDTO getUserOrder(long id, long userId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        queryWrapper.eq("userId", userId);
        Order order = orderMapper.selectOne(queryWrapper);
        OrderDTO orderDTO = DOUtils.copy(order, OrderDTO.class);
        decOneOrderItems(orderDTO);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getUserOrderList(int page, int pageSize, long userId) {
        Page<Order> orderPage = new Page<>(page, pageSize);
        Page<Order> orderPageResult = orderMapper.selectPage(orderPage, null);
        List<Order> orderList = orderPageResult.getRecords();
        return DOUtils.copyList(orderList, OrderDTO.class);
    }
}
