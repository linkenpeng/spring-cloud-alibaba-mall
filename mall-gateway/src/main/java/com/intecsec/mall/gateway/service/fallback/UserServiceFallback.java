package com.intecsec.mall.gateway.service.fallback;

import com.intecsec.mall.gateway.service.UserService;
import com.intecsec.mall.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-07-24 11:31
 **/
@Slf4j
@Component
public class UserServiceFallback implements UserService {

    @Override
    public UserDTO getUser(@PathVariable("userId") Long userId) {
        log.info("fallback getUser userId:{}", userId);
        return new UserDTO();
    }

}
