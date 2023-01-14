package com.intecsec.mall.item.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.common.utils.ListUtils;
import com.intecsec.mall.item.dto.ItemDTO;
import com.intecsec.mall.item.dto.ItemSkuDTO;
import com.intecsec.mall.item.service.ItemSkuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-14 22:22
 **/
@RestController
@RequestMapping("/item/sku")
@Slf4j
public class ItemSkuController {

    @Resource
    private ItemSkuService itemSkuService;

    @RequestMapping(value = "/listByIds", method = RequestMethod.GET)
    public ApiResponse<List<ItemSkuDTO>> skuListByIds(@RequestParam(value = "sku_ids", required = false, defaultValue = "") String skuIds) {
        List<Long> ids = ListUtils.idsToList(skuIds);
        List<ItemSkuDTO> itemSkuDTOS = itemSkuService.getItemListByIds(ids);
        return new ApiResponse(itemSkuDTOS);
    }

}
