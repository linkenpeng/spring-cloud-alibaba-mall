package com.intecsec.mall.gateway.controller;

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
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getUserName(@PathVariable Long userId) {
        log.info("获取用户信息userId:{}", userId);

        UserDTO userDTO = userService.getUser(userId);
        // UserDTO userDTO = restTemplate.getForEntity("http://user-service/user/{userId}", UserDTO.class, userId).getBody();
        return RestResponse.success(userDTO);
    }

}