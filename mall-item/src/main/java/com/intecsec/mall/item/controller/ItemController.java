package com.intecsec.mall.item.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.common.utils.ListUtils;
import com.intecsec.mall.item.dto.ItemDTO;
import com.intecsec.mall.item.dto.ItemQueryVO;
import com.intecsec.mall.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 20:17
 **/
@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {

    @Resource
    private ItemService itemService;

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public ApiResponse<ItemDTO> itemDetail(@PathVariable Long itemId) {
        ItemDTO itemDTO = itemService.itemDetail(itemId);
        return new ApiResponse(itemDTO);
    }

    @PostMapping(value = "/save")
    public ApiResponse<Integer> itemSave(@RequestBody ItemDTO itemDTO) {
        log.info("itemDTO:{}", JsonUtils.toJson(itemDTO));
        int result;
        if(itemDTO.getId() != null && itemDTO.getId() > 0L) {
            result = itemService.updateItem(itemDTO);
        } else {
            result = itemService.saveItem(itemDTO);
        }
        return new ApiResponse(result);
    }

    @RequestMapping(value = "/list/{page}/{pageSize}", method = RequestMethod.POST)
    public ApiResponse<PageData<ItemDTO>> itemList(@PathVariable Integer page, @PathVariable Integer pageSize,
                                                   @RequestBody ItemQueryVO itemQueryVO) {
        PageData<ItemDTO> pageData = itemService.itemPageList(page, pageSize, itemQueryVO);
        return new ApiResponse(pageData);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ApiResponse<Integer> delete(@PathVariable Long id) {
        int result = itemService.deleteById(id);
        return new ApiResponse(result);
    }

    @DeleteMapping(value = "/deleteBatch")
    public ApiResponse<Integer> deleteBatch(@RequestBody List<Long> idList) {
        int result = itemService.deleteByIdList(idList);
        return new ApiResponse(result);
    }

    @PutMapping(value = "/changeStatus/{id}/{status}")
    public ApiResponse<Integer> changeStatus(@PathVariable Long id,
                                             @PathVariable Integer status) {
        int result = itemService.changeStatus(id, status);
        return new ApiResponse(result);
    }

    @RequestMapping(value = "/listByIds", method = RequestMethod.GET)
    public ApiResponse<List<ItemDTO>> itemListByIds(@RequestParam(value = "item_ids", required = false, defaultValue = "") String itemIds) {
        List<Long> ids = ListUtils.idsToList(itemIds);
        List<ItemDTO> itemDTOList = itemService.getItemListByIds(ids);
        return new ApiResponse(itemDTOList);
    }

}
