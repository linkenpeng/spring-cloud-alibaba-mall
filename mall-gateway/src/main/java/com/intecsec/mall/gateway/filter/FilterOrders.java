package com.intecsec.mall.gateway.filter;

import static org.springframework.cloud.gateway.filter.NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER;

/**
 * @description: 过滤器的顺序，值越小优先级越高
 * @author: peter.peng
 * @create: 2022-12-17 17:10
 **/
public class FilterOrders {

    public static final int HttpResponseFilter = WRITE_RESPONSE_FILTER_ORDER - 2;

    public static final int IpFilter = 1;

    public static final int UrlFilter = 2;

    public static final int AuthorizeFilter = 3;
}
