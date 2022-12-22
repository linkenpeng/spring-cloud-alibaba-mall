package com.intecsec.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:03
 **/
@SpringBootApplication(scanBasePackages = {"com.intecsec.mall"})
@EnableDiscoveryClient
// @EnableOpenApi
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
