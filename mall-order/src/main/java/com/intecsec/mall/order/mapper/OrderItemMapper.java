package com.intecsec.mall.order.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.intecsec.mall.order.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}