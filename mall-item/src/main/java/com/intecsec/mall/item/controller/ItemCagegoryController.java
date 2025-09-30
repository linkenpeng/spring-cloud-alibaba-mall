package com.intecsec.mall.item.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.item.dto.ItemCategoryDTO;
import com.intecsec.mall.item.service.ItemCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-08 19:37
 **/
@RestController
@RequestMapping("/item/category")
public class ItemCagegoryController {

    @Resource
    private ItemCategoryService itemCategoryService;

    @GetMapping("/getAllCategory")
    public ApiResponse<List<ItemCategoryDTO>> getAllCategory() {
        List<ItemCategoryDTO> allCategory = itemCategoryService.getAllCategory();
        return new ApiResponse<>(allCategory);
    }

}
