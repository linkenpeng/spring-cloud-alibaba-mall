package com.intecsec.mall.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @description:
 * @author: peter.peng
 * @create: 2022-11-12 20:33
 **/
@Component
@Slf4j
public class UrlFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("经过第{}个过滤器UrlFilter", getOrder());
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getPath();
        log.info("url:" + url);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return FilterOrders.UrlFilter;
    }
}
