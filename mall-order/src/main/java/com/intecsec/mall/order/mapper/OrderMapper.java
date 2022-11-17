package com.intecsec.mall.order.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.intecsec.mall.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}