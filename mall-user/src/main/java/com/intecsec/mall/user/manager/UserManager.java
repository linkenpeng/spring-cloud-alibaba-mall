package com.intecsec.mall.user.manager;

import com.intecsec.mall.user.dto.UserDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:36
 **/
public interface UserManager {

    UserDTO getUser(Long userId);

    List<UserDTO> getUserList(int page, int pageSize);

    int update(Long userId, UserDTO userDTO);

    int delete(Long userId);
}
