package com.intecsec.mall.order.service;

import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: Feign 是一个声明式的Web Service客户端， 目的是让webservice调用更简单
 * Feign 整合了 Ribbon和Hystrix
 * @author: peter.peng
 * @create: 2020-03-22 10:28
 **/
@FeignClient(value = "USER-SERVICE")
public interface UserService {

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    UserDTO getUser(@PathVariable("userId") Long userId);

    @RequestMapping(value = "/user/consigee/{id}", method = RequestMethod.GET)
    UserConsigneeDTO getUserConsignee(@PathVariable("id") Long id);
}
