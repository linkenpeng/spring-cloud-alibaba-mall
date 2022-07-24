/**
package com.intecsec.mall.gateway.configuration;

import com.intecsec.mall.gateway.service.fallback.UserServiceFallack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class FeignConfiguration {

    @Bean
    public UserServiceFallback userServiceFallback() {
        return new UserServiceFallback();
    }
}
 **/