package com.intecsec.mall.order.api;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.order.*;
import com.intecsec.mall.order.manager.OrderManager;
import com.intecsec.mall.order.service.ItemService;
import com.intecsec.mall.order.service.UserService;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class OrderService {

    @Autowired
    private OrderManager orderManager;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrderDTO getOrder(@PathVariable(value = "id") Long id) {
        return orderManager.getOrder(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<OrderDTO> getOrderList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        return orderManager.getOrderList(page, pageSize);
    }

    @RequestMapping(value = "/{id}/{userId}", method = RequestMethod.GET)
    public OrderDTO getUserOrder(@PathVariable Long id, @PathVariable Long userId) {
        return orderManager.getUserOrder(id, userId);
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public List<OrderDTO> getUserOrderList(@PathVariable Long userId, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        return orderManager.getUserOrderList(page, pageSize, userId);
    }

    @PostMapping("/add")
    public OrderDTO addOrder(@RequestBody AddOrderDTO addOrderDTO) {

        UserConsigneeDTO userConsigneeDTO = userService.getUserConsignee(addOrderDTO.getConsignee_id());
        OrderConsigneeDTO orderConsigneeDTO = DOUtils.copy(userConsigneeDTO, OrderConsigneeDTO.class);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(addOrderDTO.getUser_id());

        List<Long> itemIds = new ArrayList<>();
        Map<Long, Integer> itemNumberMap = new HashMap<>();
        for(AddOrderItemDTO addOrderItemDTO : addOrderDTO.getOrder_item_list()) {
            itemIds.add(addOrderItemDTO.getItem_id());
            itemNumberMap.put(addOrderItemDTO.getItem_id(), addOrderItemDTO.getNumber());
        }

        List<ItemDTO> itemDTOS = itemService.itemListByIds(StringUtils.join(itemIds, ","));

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


        return orderManager.addOrder(orderDTO);
    }
}