package com.intecsec.mall.order.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.order.*;
import com.intecsec.mall.order.manager.OrderManager;
import com.intecsec.mall.order.service.ItemService;
import com.intecsec.mall.order.service.UserService;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 20:18
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderManager orderManager;

    @Resource
    private UserService userService;

    @Resource
    private ItemService itemService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResponse<OrderDTO> getOrder(@PathVariable(value = "id") Long id) {
        OrderDTO orderDTO = orderManager.getOrder(id);
        return new ApiResponse(orderDTO);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResponse<List<OrderDTO>> getOrderList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        List<OrderDTO> orderDTOList = orderManager.getOrderList(page, pageSize);
        return new ApiResponse(orderDTOList);
    }

    @RequestMapping(value = "/{id}/{userId}", method = RequestMethod.GET)
    public ApiResponse<OrderDTO> getUserOrder(@PathVariable Long id, @PathVariable Long userId) {
        OrderDTO orderDTO =  orderManager.getUserOrder(id, userId);
        return new ApiResponse(orderDTO);
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public ApiResponse<List<OrderDTO>> getUserOrderList(@PathVariable Long userId, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        List<OrderDTO> orderDTOList = orderManager.getUserOrderList(page, pageSize, userId);
        return new ApiResponse(orderDTOList);
    }

    @PostMapping("/add")
    public ApiResponse<OrderDTO> addOrder(@RequestBody AddOrderDTO addOrderDTO) {

        ApiResponse<UserConsigneeDTO> userConsigneeResponse = userService.getUserConsignee(addOrderDTO.getConsignee_id());
        UserConsigneeDTO userConsigneeDTO = userConsigneeResponse.getData();

        OrderConsigneeDTO orderConsigneeDTO = DOUtils.copy(userConsigneeDTO, OrderConsigneeDTO.class);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(addOrderDTO.getUser_id());

        List<Long> itemIds = new ArrayList<>();
        Map<Long, Integer> itemNumberMap = new HashMap<>();
        for(AddOrderItemDTO addOrderItemDTO : addOrderDTO.getOrder_item_list()) {
            itemIds.add(addOrderItemDTO.getItem_id());
            itemNumberMap.put(addOrderItemDTO.getItem_id(), addOrderItemDTO.getNumber());
        }

        ApiResponse<List<ItemDTO>> itemResponse = itemService.itemListByIds(StringUtils.join(itemIds, ","));
        List<ItemDTO> itemDTOS = itemResponse.getData();

        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        long orderPriceAmount = 0L;
        for(ItemDTO itemDTO : itemDTOS) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setItemId(itemDTO.getId());
            orderItemDTO.setItemNum(itemNumberMap.get(itemDTO.getId()));
            orderItemDTO.setItemPrice(itemDTO.getItemPrice());
            orderItemDTO.setItemName(itemDTO.getItemName());

            orderPriceAmount += itemDTO.getItemPrice();

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

        OrderDTO returnOrderDTO = orderManager.addOrder(orderDTO);

        return new ApiResponse(returnOrderDTO);
    }
}