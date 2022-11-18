package com.intecsec.mall.gateway.filter;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.common.utils.GZIPUtils;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.common.utils.ResponseUtil;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.cloud.gateway.filter.NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER;

/**
 * @description: 响应体转换处理
 * @author: peter.peng
 * @create: 2022-11-18 21:43
 **/
@Component
public class HttpResponseBodyGlobalFilter implements GlobalFilter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public int getOrder() {
        // -1 is response write filter, must be called before that
        return WRITE_RESPONSE_FILTER_ORDER - 2;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("global filter HttpResponseBody，processing response results");

        // 这里可以增加一些业务判断条件，进行跳过处理

        ServerHttpResponse response = exchange.getResponse();
        DataBufferFactory bufferFactory = response.bufferFactory();
        // 响应装饰
        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(response) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                logger.info("global filter HttpResponseBody，Response processing，getStatusCode={}", getStatusCode());
                if (getStatusCode() != null && body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = Flux.from(body);
                    return super.writeWith(fluxBody.buffer().map(dataBuffers -> {
                        // 如果响应过大，会进行截断，出现乱码，看api DefaultDataBufferFactory
                        // 有个join方法可以合并所有的流，乱码的问题解决
                        DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
                        DataBuffer dataBuffer = dataBufferFactory.join(dataBuffers);
                        byte[] content = new byte[dataBuffer.readableByteCount()];
                        dataBuffer.read(content);
                        // 释放掉内存
                        DataBufferUtils.release(dataBuffer);

                        List<String> encodingList = exchange.getResponse().getHeaders().get(HttpHeaders.CONTENT_ENCODING);
                        boolean zip = encodingList != null && encodingList.contains("gzip");
                        // responseData就是response的值，就可查看修改了
                        String responseData = getResponseData(zip, content);

                        // 重置返回参数
                        String result = responseConversion(responseData);
                        byte[] uppedContent = getUppedContent(zip, result);
                        response.getHeaders().setContentLength(uppedContent.length);
                        response.setStatusCode(HttpStatus.OK);

                        return bufferFactory.wrap(uppedContent);
                    }));
                }
                // if body is not a flux. never got there.
                return super.writeWith(body);
            }
        };
        // replace response with decorator
        return chain.filter(exchange.mutate().response(decoratedResponse).build());
    }

    private String responseConversion(String result) {
        try {
            logger.info("响应结果为：{}", result);
            return ResponseUtil.success(JsonUtils.parseJson(result, ApiResponse.class));
        } catch (Exception e) {
            logger.error("响应包装转换失败，异常信息为：", e);
            return result;
        }
    }

    private String getResponseData(boolean zip, byte[] content) {
        String responseData;
        if (zip) {
            responseData = GZIPUtils.uncompressToString(content);
        } else {
            responseData = new String(content, StandardCharsets.UTF_8);
        }
        return responseData;
    }


    private byte[] getUppedContent(boolean zip, String result) {
        byte[] uppedContent;
        if (zip) {
            uppedContent = GZIPUtils.compress(result);
        } else {
            uppedContent = result.getBytes(StandardCharsets.UTF_8);
        }
        return uppedContent;
    }

}

