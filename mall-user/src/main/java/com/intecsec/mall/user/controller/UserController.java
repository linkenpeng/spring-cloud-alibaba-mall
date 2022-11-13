package com.intecsec.mall.user.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.manager.UserConsigneeManager;
import com.intecsec.mall.user.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:20
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserConsigneeManager userConsigneeManager;

    @Value("${server.port}")
    private int serverPort = 0;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ApiResponse<UserDTO> getUser(@PathVariable Long userId) {
        UserDTO userDTO = userManager.getUser(userId);
        userDTO.setUserServicePort(serverPort);
        return new ApiResponse(userDTO);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResponse<List<UserDTO>> getUserList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        List<UserDTO> userDTOList = userManager.getUserList(page, pageSize);
        return new ApiResponse<>(userDTOList);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public ApiResponse<Integer> update(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        int id = userManager.update(userId, userDTO);
        return new ApiResponse(id);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ApiResponse<Integer> delete(@PathVariable Long userId) {
        int id = userManager.delete(userId);
        return new ApiResponse(id);
    }

    @RequestMapping(value = "/consigee/{id}", method = RequestMethod.GET)
    public ApiResponse<UserConsigneeDTO> getUserConsignee(@PathVariable Long id) {
        UserConsigneeDTO userConsigneeDTO = userConsigneeManager.getOne(id);
        return new ApiResponse(userConsigneeDTO);
    }
}
