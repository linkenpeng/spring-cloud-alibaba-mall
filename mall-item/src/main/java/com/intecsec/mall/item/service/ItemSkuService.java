package com.intecsec.mall.item.service;

import com.intecsec.mall.item.dto.ItemSkuDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-14 22:23
 **/
public interface ItemSkuService {

    List<ItemSkuDTO> getSkuListByIds(List<Long> ids);

    ItemSkuDTO getSkuById(Long id);

    int addSku(ItemSkuDTO itemSkuDTO);

    int deleteById(Long id);

    int updateSku(ItemSkuDTO itemSkuDTO);

    int changeStatus(Long id, Integer status);
}
