package com.intecsec.mall.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("mall_order_item")
public class OrderItem {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Long skuId;

    private Long itemId;

    private Long skuPrice;

    private Integer skuNum;

    private String skuName;

    private Long actualPrice;

    private Long couponAmount;

    private Long pointAmount;

    private Long discountAmount;

    private Date gmtCreated;

    private Date gmtUpdated;

    @TableLogic
    private Byte deleteMark;
}