package com.intecsec.mall.gateway.api;

import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.gateway.service.OrderService;
import com.intecsec.mall.gateway.service.UserService;
import com.intecsec.mall.order.AddOrderDTO;
import com.intecsec.mall.order.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:32
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController  {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/add")
    public Object addOrder(@RequestBody @Valid AddOrderDTO addOrderDTO) {
        log.info("addOrderDTO:{}", JsonUtils.toJson(addOrderDTO));

        addOrderDTO.setUser_id(1L);
        OrderDTO orderDTO = orderService.addOrder(addOrderDTO);

        return RestResponse.success(orderDTO);
    }

    @ResponseBody
    @GetMapping("/list")
    public Object getOrderList(@RequestParam(name = "page_num", required = false, defaultValue = "1") int pageNum,
                               @RequestParam(name = "page_size", required = false, defaultValue = "20") int pageSize) {
        return RestResponse.success(orderService.getOrderList(pageNum, pageSize));
    }

    @ResponseBody
    @GetMapping("/{orderId}")
    public Object getOrder(@PathVariable Long orderId) {
        return RestResponse.success(orderService.getOrder(orderId));
    }

    @ResponseBody
    @GetMapping("/user/list")
    public Object getUserOrderList(@RequestParam(name = "page_num", required = false, defaultValue = "1") int pageNum,
                                   @RequestParam(name = "page_size", required = false, defaultValue = "20") int pageSize) {
        long userId = 1;
        return RestResponse.success(orderService.getUserOrderList(userId, pageNum, pageSize));
    }

    @ResponseBody
    @GetMapping("/user/{orderId}")
    public Object getUserOrder(@PathVariable Long orderId) {
        long userId = 1;
        return RestResponse.success(orderService.getUserOrder(userId, orderId));
    }

}