package com.intecsec.mall.item.service.impl;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.item.dto.ItemCategoryDTO;
import com.intecsec.mall.item.entity.ItemCategory;
import com.intecsec.mall.item.mapper.ItemCategoryMapper;
import com.intecsec.mall.item.service.ItemCategoryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-08 19:34
 **/
@Component
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Resource
    private ItemCategoryMapper itemCategoryMapper;

    @Override
    public List<ItemCategoryDTO> getAllCategory() {
        List<ItemCategory> itemCategories = itemCategoryMapper.selectList(null);
        return DOUtils.copyList(itemCategories, ItemCategoryDTO.class);
    }
}
