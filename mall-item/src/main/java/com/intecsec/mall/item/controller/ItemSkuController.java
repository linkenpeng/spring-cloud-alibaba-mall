package com.intecsec.mall.item.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.common.utils.ListUtils;
import com.intecsec.mall.item.dto.ItemSkuDTO;
import com.intecsec.mall.item.service.ItemSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @GetMapping(value = "/listByIds")
    public ApiResponse<List<ItemSkuDTO>> skuListByIds(@RequestParam(value = "sku_ids",
            required = false, defaultValue = "") String skuIds) {
        List<Long> ids = ListUtils.idsToList(skuIds);
        List<ItemSkuDTO> itemSkuDTOS = itemSkuService.getSkuListByIds(ids);
        return new ApiResponse(itemSkuDTOS);
    }

    @GetMapping(value = "/listByItemId/{itemId}")
    public ApiResponse<List<ItemSkuDTO>> skuListByItemId(@PathVariable Long itemId) {
        List<ItemSkuDTO> itemSkuDTOS = itemSkuService.getSkuListByItemId(itemId);
        return new ApiResponse(itemSkuDTOS);
    }

    @PostMapping(value = "/save")
    public ApiResponse<Integer> itemSave(@RequestBody ItemSkuDTO itemSkuDTO) {
        log.info("itemSkuDTO:{}", JsonUtils.toJson(itemSkuDTO));
        int result;
        if(itemSkuDTO.getId() != null && itemSkuDTO.getId() > 0L) {
            result = itemSkuService.updateSku(itemSkuDTO);
        } else {
            result = itemSkuService.addSku(itemSkuDTO);
        }
        return new ApiResponse(result);
    }

    @PutMapping(value = "/changeStatus/{id}/{status}")
    public ApiResponse<Integer> changeStatus(@PathVariable Long id,
                                             @PathVariable Integer status) {
        int result = itemSkuService.changeStatus(id, status);
        return new ApiResponse(result);
    }

    @GetMapping(value = "/{skuId}")
    public ApiResponse<ItemSkuDTO> itemDetail(@PathVariable Long skuId) {
        ItemSkuDTO itemSkuDTO = itemSkuService.getSkuById(skuId);
        return new ApiResponse(itemSkuDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ApiResponse<Integer> delete(@PathVariable Long id) {
        int result = itemSkuService.deleteById(id);
        return new ApiResponse(result);
    }

}
