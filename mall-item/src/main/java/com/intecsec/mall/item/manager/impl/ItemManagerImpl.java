package com.intecsec.mall.item.manager.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.item.ItemDTO;
import com.intecsec.mall.item.entity.Item;
import com.intecsec.mall.item.manager.ItemManager;
import com.intecsec.mall.item.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:21
 **/
@Component
public class ItemManagerImpl implements ItemManager {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public ItemDTO itemDetail(Long itemId) {
        Item item = itemMapper.selectById(itemId);
        return DOUtils.copy(item, ItemDTO.class);
    }

    @Override
    public List<ItemDTO> itemList(int page, int pageSize) {
        Page<Item> itemPage = new Page<>(page, pageSize);
        Page<Item> itemPageResult = itemMapper.selectPage(itemPage, null);
        List<Item> itemList = itemPageResult.getRecords();
        return DOUtils.copyList(itemList, ItemDTO.class);
    }

    @Override
    public List<ItemDTO> getItemListByIds(List<Long> ids) {
        List<Item> itemList = itemMapper.selectBatchIds(ids);
        return DOUtils.copyList(itemList, ItemDTO.class);
    }
}
