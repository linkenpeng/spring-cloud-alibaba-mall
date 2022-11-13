package com.intecsec.mall.item.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.item.manager.ItemManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 20:17
 **/
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemManager itemManager;

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public ApiResponse<ItemDTO> itemDetail(@PathVariable Long itemId) {
        ItemDTO itemDTO = itemManager.itemDetail(itemId);
        return new ApiResponse(itemDTO);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResponse<List<ItemDTO>> itemList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "2") int pageSize) {
        List<ItemDTO> itemDTOS = itemManager.itemList(page, pageSize);
        return new ApiResponse(itemDTOS);
    }


    @RequestMapping(value = "/listByIds", method = RequestMethod.GET)
    public ApiResponse<List<ItemDTO>> itemListByIds(@RequestParam(value = "item_ids", required = false, defaultValue = "") String itemIds) {
        List<Long> ids = new ArrayList<>();
        if(StringUtils.isNotEmpty(itemIds)) {
            String idSplit[] = StringUtils.split(itemIds, ",");
            for(String id : idSplit) {
                ids.add(Long.parseLong(id));
            }
        }

        List<ItemDTO> itemDTOList = itemManager.getItemListByIds(ids);
        return new ApiResponse(itemDTOList);
    }

}
