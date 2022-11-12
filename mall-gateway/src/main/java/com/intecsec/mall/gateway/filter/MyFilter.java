package com.intecsec.mall.gateway.filter;

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
public class MyFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String Path = request.getPath().pathWithinApplication().value();

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
