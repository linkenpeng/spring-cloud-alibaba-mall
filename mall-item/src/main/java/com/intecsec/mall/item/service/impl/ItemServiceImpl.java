package com.intecsec.mall.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.item.dto.ItemCategoryDTO;
import com.intecsec.mall.item.dto.ItemDTO;
import com.intecsec.mall.item.dto.ItemQueryVO;
import com.intecsec.mall.item.entity.Item;
import com.intecsec.mall.item.entity.ItemCategory;
import com.intecsec.mall.item.mapper.ItemCategoryMapper;
import com.intecsec.mall.item.mapper.ItemMapper;
import com.intecsec.mall.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:21
 **/
@Component
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Resource
    private ItemCategoryMapper itemCategoryMapper;

    @Override
    public ItemDTO itemDetail(Long itemId) {
        Item item = itemMapper.selectById(itemId);
        return DOUtils.copy(item, ItemDTO.class);
    }

    @Override
    public List<ItemDTO> itemList(int page, int pageSize) {
        log.info("itemList page:{}, pageSize:{}", page, pageSize);
        Page<Item> itemPage = new Page<>(page, pageSize);
        Page<Item> itemPageResult = itemMapper.selectPage(itemPage, null);
        log.info("itemPage:{}", JsonUtils.toJson(itemPageResult));
        List<Item> itemList = itemPageResult.getRecords();
        return DOUtils.copyList(itemList, ItemDTO.class);
    }

    @Override
    public PageData<ItemDTO> itemPageList(int page, int pageSize, ItemQueryVO itemQueryVO) {
        log.info("itemList page:{}, pageSize:{}, itemQueryVO:{}",
                page, pageSize, JsonUtils.toJson(itemQueryVO));

        QueryWrapper<Item> queryWrapper = getQueryWrapper(itemQueryVO);

        Page<Item> itemPage = new Page<>(page, pageSize);
        Page<Item> itemPageResult = itemMapper.selectPage(itemPage, queryWrapper);
        List<Item> itemList = itemPageResult.getRecords();
        List<ItemDTO> itemDTOS = DOUtils.copyList(itemList, ItemDTO.class);

        decItemCategory(itemDTOS);

        PageData<ItemDTO> pageData = new PageData<>();
        pageData.setList(itemDTOS);
        pageData.setTotal(itemPageResult.getTotal());
        pageData.setSize(itemPageResult.getSize());
        pageData.setCurrent(itemPageResult.getCurrent());

        return pageData;
    }

    private QueryWrapper<Item> getQueryWrapper(ItemQueryVO itemQueryVO) {
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        if(Objects.nonNull(itemQueryVO)) {
            if(StringUtils.isNotEmpty(itemQueryVO.getItemName())) {
                queryWrapper.eq("item_name", itemQueryVO.getItemName());
            }
            // 大于
            if(Objects.nonNull(itemQueryVO.getLowPrice())) {
                queryWrapper.ge("item_price", itemQueryVO.getLowPrice());
            }
            // 小于
            if(Objects.nonNull(itemQueryVO.getHighPrice())) {
                queryWrapper.le("item_price", itemQueryVO.getHighPrice());
            }
            // 分类
            if(Objects.nonNull(itemQueryVO.getCategoryId())) {
                queryWrapper.eq("category_id", itemQueryVO.getCategoryId());
            }
        }
        return queryWrapper;
    }

    private void decItemCategory(List<ItemDTO> itemDTOS) {
        if(itemDTOS != null && itemDTOS.size() > 0) {
            List<Long> categoryIds = itemDTOS.stream().map(ItemDTO::getCategoryId)
                    .collect(Collectors.toList());
            List<ItemCategory> itemCategories = itemCategoryMapper.selectBatchIds(categoryIds);
            Map<Long, ItemCategory> itemCategoryMap = itemCategories.stream()
                    .collect(Collectors.toMap(ItemCategory::getId, v -> v));
            for(ItemDTO itemDTO : itemDTOS) {
                ItemCategory itemCategory = itemCategoryMap.get(itemDTO.getCategoryId());
                itemDTO.setItemCategory(DOUtils.copy(itemCategory, ItemCategoryDTO.class));
            }
        }
    }


    @Override
    public List<ItemDTO> getItemListByIds(List<Long> ids) {
        List<Item> itemList = itemMapper.selectBatchIds(ids);
        return DOUtils.copyList(itemList, ItemDTO.class);
    }

    @Override
    public int deleteById(Long id) {
        return itemMapper.deleteById(id);
    }
}
