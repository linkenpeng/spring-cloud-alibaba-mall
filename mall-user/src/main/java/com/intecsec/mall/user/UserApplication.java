package com.intecsec.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:03
 **/
@SpringBootApplication
@EnableDiscoveryClient
// @EnableOpenApi
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
