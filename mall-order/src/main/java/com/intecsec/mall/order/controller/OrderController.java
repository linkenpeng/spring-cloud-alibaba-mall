package com.intecsec.mall.order.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.order.dto.AddOrderDTO;
import com.intecsec.mall.order.dto.OrderDTO;
import com.intecsec.mall.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 20:18
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResponse<OrderDTO> getOrder(@PathVariable(value = "id") Long id) {
        OrderDTO orderDTO = orderService.getOrder(id);
        return new ApiResponse(orderDTO);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResponse<List<OrderDTO>> getOrderList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        List<OrderDTO> orderDTOList = orderService.getOrderList(page, pageSize);
        return new ApiResponse(orderDTOList);
    }

    @RequestMapping(value = "/{id}/{userId}", method = RequestMethod.GET)
    public ApiResponse<OrderDTO> getUserOrder(@PathVariable Long id, @PathVariable Long userId) {
        OrderDTO orderDTO =  orderService.getUserOrder(id, userId);
        return new ApiResponse(orderDTO);
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public ApiResponse<List<OrderDTO>> getUserOrderList(@PathVariable Long userId, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        List<OrderDTO> orderDTOList = orderService.getUserOrderList(page, pageSize, userId);
        return new ApiResponse(orderDTOList);
    }

    @PostMapping("/add")
    public ApiResponse<OrderDTO> addOrder(@RequestBody AddOrderDTO addOrderDTO) {
        OrderDTO returnOrderDTO = orderService.addOrder(addOrderDTO);
        return new ApiResponse(returnOrderDTO);
    }
}