package com.intecsec.mall.item.manager;

import com.intecsec.mall.item.ItemDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:19
 **/
public interface ItemManager {

    ItemDTO itemDetail(Long itemId);

    List<ItemDTO> itemList(int page, int pageSize);

    List<ItemDTO> getItemListByIds(List<Long> ids);
}
