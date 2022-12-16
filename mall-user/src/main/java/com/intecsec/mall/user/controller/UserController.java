package com.intecsec.mall.user.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.dto.UserLoginDTO;
import com.intecsec.mall.user.service.UserConsigneeService;
import com.intecsec.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:20
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserConsigneeService userConsigneeService;

    @Value("${server.port}")
    private int serverPort = 0;

    @PostMapping("/register")
    public ApiResponse<Integer> register(@RequestBody UserDTO userDTO) {
        int add = userService.add(userDTO);
        return new ApiResponse<>(add);
    }

    @PostMapping("/login")
    public ApiResponse<UserLoginDTO> login(@RequestBody UserDTO userDTO) {
        UserLoginDTO userLoginDTO = userService.login(userDTO);
        return new ApiResponse<>(userLoginDTO);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ApiResponse<UserDTO> getUser(@PathVariable Long userId) {
        UserDTO userDTO = userService.getUser(userId);
        userDTO.setUserServicePort(serverPort);
        return new ApiResponse(userDTO);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResponse<List<UserDTO>> getUserList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        List<UserDTO> userDTOList = userService.getUserList(page, pageSize);
        return new ApiResponse<>(userDTOList);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public ApiResponse<Integer> update(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        int id = userService.update(userId, userDTO);
        return new ApiResponse(id);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ApiResponse<Integer> delete(@PathVariable Long userId) {
        int id = userService.delete(userId);
        return new ApiResponse(id);
    }

    @RequestMapping(value = "/consigee/{id}", method = RequestMethod.GET)
    public ApiResponse<UserConsigneeDTO> getUserConsignee(@PathVariable Long id) {
        UserConsigneeDTO userConsigneeDTO = userConsigneeService.getOne(id);
        return new ApiResponse(userConsigneeDTO);
    }
}
