package com.intecsec.mall.order.service;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.item.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description: Feign 是一个声明式的Web Service客户端， 目的是让webservice调用更简单
 * Feign 整合了 Ribbon和Hystrix
 * @author: peter.peng
 * @create: 2020-03-22 10:28
 **/
@FeignClient(value = "item-service")
public interface ItemService {

    @RequestMapping(value = "/item/listByIds", method = RequestMethod.GET)
    ApiResponse<List<ItemDTO>> itemListByIds(@RequestParam(value = "item_ids", required = false, defaultValue = "") String itemIds);
}
