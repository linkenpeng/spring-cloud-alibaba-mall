package com.intecsec.mall.order.manager.impl;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.order.OrderDTO;
import com.intecsec.mall.order.OrderItemDTO;
import com.intecsec.mall.order.constant.OrderStatusEnum;
import com.intecsec.mall.order.entity.Order;
import com.intecsec.mall.order.entity.OrderConsignee;
import com.intecsec.mall.order.entity.OrderItem;
import com.intecsec.mall.order.manager.OrderManager;
import com.intecsec.mall.order.mapper.OrderConsigneeMapper;
import com.intecsec.mall.order.mapper.OrderItemMapper;
import com.intecsec.mall.order.mapper.OrderMapper;
import com.intecsec.mall.order.util.OrderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:28
 **/
@Component
@Slf4j
public class OrderManagerImpl implements OrderManager {

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderConsigneeMapper orderConsigneeMapper;

    @Override
    public OrderDTO getOrder(long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        OrderDTO orderDTO = DOUtils.copy(order, OrderDTO.class);

        decOneOrderItems(orderDTO);

        return orderDTO;
    }

    @Override
    public List<OrderDTO> getOrderList(int page, int pageSize) {
        int offset = getOffset(page, pageSize);
        List<Order> orderList = orderMapper.getList(offset, pageSize);
        return DOUtils.copyList(orderList, OrderDTO.class);
    }

    @Override
    public OrderDTO getUserOrder(long id, long userId) {
        Order order = orderMapper.getUserOrder(id, userId);
        OrderDTO orderDTO = DOUtils.copy(order, OrderDTO.class);
        decOneOrderItems(orderDTO);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getUserOrderList(int page, int pageSize, long userId) {
        int offset = getOffset(page, pageSize);
        List<Order> orderList = orderMapper.getUserOrderList(userId, offset, pageSize);
        return DOUtils.copyList(orderList, OrderDTO.class);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = DOUtils.copy(orderDTO, Order.class);
        order.setOrderStatus(OrderStatusEnum.UN_PAID.getOrderStatus());

        OrderConsignee orderConsignee = DOUtils.copy(orderDTO.getOrderConsignee(), OrderConsignee.class);

        order.setOrderSn(OrderUtil.genOrderSn());
        long row = orderMapper.insertSelective(order);
        log.info("insert rows:{}", row);
        long orderId = order.getId();

        orderConsignee.setOrderId(orderId);
        orderConsigneeMapper.insertSelective(orderConsignee);

        List<OrderItem> orderItems = DOUtils.copyList(orderDTO.getOrderItemList(), OrderItem.class);
        for(OrderItem orderItem : orderItems) {
            orderItem.setOrderId(orderId);
            orderItemMapper.insertSelective(orderItem);
        }

        orderDTO.setId(orderId);
        orderDTO.setOrderSn(order.getOrderSn());

        return orderDTO;
    }

    private int getOffset(int page, int pageSize) {
        return (page - 1) * pageSize;
    }

    private void decOneOrderItems(OrderDTO orderDTO) {
        List<OrderItem> orderItems = orderItemMapper.getListByOrderId(orderDTO.getId());
        Map<Long, List<OrderItemDTO>> orderItemMap = getOrderItemMap(orderItems);
        orderDTO.setOrderItemList(orderItemMap.get(orderDTO.getId()));
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
}
