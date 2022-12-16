package com.intecsec.mall.user.service;

import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.dto.UserLoginDTO;
import com.intecsec.mall.user.entity.User;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:36
 **/
public interface UserService {

    UserDTO getUser(Long userId);

    List<UserDTO> getUserList(int page, int pageSize);

    int add(UserDTO userDTO);

    UserLoginDTO login(UserDTO userDTO);

    int update(Long userId, UserDTO userDTO);

    int delete(Long userId);
}
