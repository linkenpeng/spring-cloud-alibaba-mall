package com.intecsec.mall.user.controller;

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
    public UserDTO getUser(@PathVariable Long userId) {
        UserDTO userDTO = userManager.getUser(userId);
        userDTO.setUserServicePort(serverPort);
        return userDTO;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserDTO> getUserList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        return userManager.getUserList(page, pageSize);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public int update(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        return userManager.update(userId, userDTO);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long userId) {
        return userManager.delete(userId);
    }

    @RequestMapping(value = "/consigee/{id}", method = RequestMethod.GET)
    public UserConsigneeDTO getUserConsignee(@PathVariable Long id) {
        UserConsigneeDTO userConsigneeDTO = userConsigneeManager.getOne(id);
        return userConsigneeDTO;
    }
}
