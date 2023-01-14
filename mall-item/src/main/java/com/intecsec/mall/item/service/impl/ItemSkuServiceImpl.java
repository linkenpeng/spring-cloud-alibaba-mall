package com.intecsec.mall.item.service.impl;

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
    public List<ItemSkuDTO> getItemListByIds(List<Long> ids) {
        List<ItemSku> itemSkus = itemSkuMapper.selectBatchIds(ids);
        return DOUtils.copyList(itemSkus, ItemSkuDTO.class);
    }

}
