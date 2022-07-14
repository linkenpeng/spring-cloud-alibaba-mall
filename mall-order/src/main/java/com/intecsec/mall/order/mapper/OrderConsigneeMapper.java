package com.intecsec.mall.order.mapper;


import com.intecsec.mall.order.entity.OrderConsignee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderConsigneeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderConsignee record);

    int insertSelective(OrderConsignee record);

    OrderConsignee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderConsignee record);

    int updateByPrimaryKey(OrderConsignee record);
}