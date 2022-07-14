package com.intecsec.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 10:04
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    @LoadBalanced
    @Bean(value = "restTemplate")
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
