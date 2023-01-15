package com.intecsec.mall.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.item.dto.ItemSkuDTO;
import com.intecsec.mall.item.entity.ItemSku;
import com.intecsec.mall.item.mapper.ItemSkuMapper;
import com.intecsec.mall.item.service.ItemSkuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-14 22:30
 **/
@Component
public class ItemSkuServiceImpl implements ItemSkuService {

    @Resource
    private ItemSkuMapper itemSkuMapper;

    @Override
    public List<ItemSkuDTO> getSkuListByIds(List<Long> ids) {
        List<ItemSku> itemSkus = itemSkuMapper.selectBatchIds(ids);
        return DOUtils.copyList(itemSkus, ItemSkuDTO.class);
    }

    @Override
    public List<ItemSkuDTO> getSkuListByItemId(Long itemId) {
        QueryWrapper<ItemSku> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        List<ItemSku> itemSkus = itemSkuMapper.selectList(queryWrapper);
        return DOUtils.copyList(itemSkus, ItemSkuDTO.class);
    }

    @Override
    public ItemSkuDTO getSkuById(Long id) {
        ItemSku itemSku = itemSkuMapper.selectById(id);
        return DOUtils.copy(itemSku, ItemSkuDTO.class);
    }

    @Override
    public int addSku(ItemSkuDTO itemSkuDTO) {
        ItemSku itemSku = DOUtils.copy(itemSkuDTO, ItemSku.class);
        return itemSkuMapper.insert(itemSku);
    }

    @Override
    public int deleteById(Long id) {
        return itemSkuMapper.deleteById(id);
    }

    @Override
    public int updateSku(ItemSkuDTO itemSkuDTO) {
        ItemSku itemSku = DOUtils.copy(itemSkuDTO, ItemSku.class);
        return itemSkuMapper.updateById(itemSku);
    }

    @Override
    public int changeStatus(Long id, Integer status) {
        ItemSku itemSku = itemSkuMapper.selectById(id);
        itemSku.setStatus(status);
        return itemSkuMapper.updateById(itemSku);
    }
}
