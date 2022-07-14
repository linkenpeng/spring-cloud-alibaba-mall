package com.intecsec.mall.item.mapper;

import com.intecsec.mall.item.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> getList(@Param("offset") Integer offset, @Param("count") Integer count);

    List<Item> getListByIds(@Param("ids") List<Long> ids);
}