package com.intecsec.mall.gateway.filter;

import com.intecsec.mall.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-17 16:04
 **/
@Component
@Slf4j
public class AuthorizeFilter implements GlobalFilter, Ordered {
    private static final String AUTHORIZE_TOKEN = "token";

    private static final String NEED_TOKEN_ENV = "online";

    @Value("${spring.profiles.active}")
    private String env;

    private static final Set<String> NO_NEED_TOKEN = new HashSet<>();
    static {
        NO_NEED_TOKEN.add("/user/login");
        NO_NEED_TOKEN.add("/user/register");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("经过第{}个过滤器AuthorizeFilter, env:{}", getOrder(), env);

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 放行的url
        String urlPath = request.getURI().getPath();
        log.info("urlPath:{}", urlPath);
        for(String url : NO_NEED_TOKEN) {
            if (urlPath.contains(url)) {
                return chain.filter(exchange);
            }
        }

        if(NEED_TOKEN_ENV.equals(env)) {
            HttpHeaders headers = request.getHeaders();
            String token = headers.getFirst(AUTHORIZE_TOKEN);
            log.info("token:{}", token);

            if (StringUtils.isEmpty(token)) {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            try {
                Claims claims = JwtUtil.parseJWT(token);
                log.info("claims:{}", claims);
            } catch (Exception e) {
                log.error("解析token出错", e);
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return FilterOrders.AuthorizeFilter;
    }
}
