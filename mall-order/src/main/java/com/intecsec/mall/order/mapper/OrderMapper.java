package com.intecsec.mall.order.mapper;


import com.intecsec.mall.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    long insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    Order getUserOrder(@Param("id") Long id, @Param("userId") Long userId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> getList(@Param("offset") Integer offset, @Param("count") Integer count);

    List<Order> getUserOrderList(@Param("userId") Long userId, @Param("offset") Integer offset, @Param("count") Integer count);
}