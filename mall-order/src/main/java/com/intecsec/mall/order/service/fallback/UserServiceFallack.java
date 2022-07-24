package com.intecsec.mall.order.service.fallback;

import com.intecsec.mall.order.service.UserService;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-07-24 11:31
 **/
public class UserServiceFallack implements UserService {

    @Override
    public UserDTO getUser(@PathVariable("userId") Long userId) {
        return new UserDTO();
    }

    @Override
    public UserConsigneeDTO getUserConsignee(@PathVariable("id") Long id) {
        return new UserConsigneeDTO();
    }
}
