package com.intecsec.mall.gateway.controller;

import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.gateway.service.UserService;
import com.intecsec.mall.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:32
 **/
@RestController
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public Object getUserName(@PathVariable Long userId) {
        log.info("获取用户信息 request userId:{}", userId);

        // 有两种方式可以远程调用user-service, 1: 通过RestTemplate 2. 通过FeignClient
        UserDTO userDTO = userService.getUser(userId);
        // UserDTO userDTO = restTemplate.getForEntity("http://user-service/user/{userId}", UserDTO.class, userId).getBody();
        log.info("获取用户信息 response userDTO:{}", JsonUtils.toJson(userDTO));

        return RestResponse.success(userDTO);
    }

}