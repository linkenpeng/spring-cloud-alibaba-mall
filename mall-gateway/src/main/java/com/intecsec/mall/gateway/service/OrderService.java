package com.intecsec.mall.gateway.service;

import com.intecsec.mall.order.AddOrderDTO;
import com.intecsec.mall.order.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: Feign 是一个声明式的Web Service客户端， 目的是让webservice调用更简单
 * Feign 整合了 Ribbon和Hystrix
 * @author: peter.peng
 * @create: 2020-03-22 10:28
 **/
@FeignClient(value = "order-service")
public interface OrderService {

    @PostMapping("/order/add")
    OrderDTO addOrder(@RequestBody AddOrderDTO addOrderDTO);

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    OrderDTO getOrder(@PathVariable(value="id") Long id);

    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    List<OrderDTO> getOrderList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize);

    @RequestMapping(value = "/order/{id}/{userId}", method = RequestMethod.GET)
    OrderDTO getUserOrder(@PathVariable(value="id")  Long id, @PathVariable(value="userId")  Long userId);

    @RequestMapping(value = "/order/list/{userId}", method = RequestMethod.GET)
    List<OrderDTO> getUserOrderList(@PathVariable(value="userId")  Long userId, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize);
}
