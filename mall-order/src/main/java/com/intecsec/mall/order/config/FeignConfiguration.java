package com.intecsec.mall.order.config;

import com.intecsec.mall.order.client.fallback.UserClientFallack;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-07-24 11:34
 **/
public class FeignConfiguration {

    @Bean
    public UserClientFallack userServiceFallack() {
        return new UserClientFallack();
    }
}
