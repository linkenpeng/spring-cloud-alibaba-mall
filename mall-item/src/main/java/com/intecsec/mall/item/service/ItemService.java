package com.intecsec.mall.item.service;

import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.item.dto.ItemDTO;
import com.intecsec.mall.item.dto.ItemQueryVO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:19
 **/
public interface ItemService {

    ItemDTO itemDetail(Long itemId);

    int saveItem(ItemDTO itemDTO);

    int updateItem(ItemDTO itemDTO);

    List<ItemDTO> itemList(int page, int pageSize);

    PageData<ItemDTO> itemPageList(int page, int pageSize, ItemQueryVO itemQueryVO);

    List<ItemDTO> getItemListByIds(List<Long> ids);

    int deleteById(Long id);

    int deleteByIdList(List<Long> idList);

    int changeStatus(Long id, Integer status);
}
