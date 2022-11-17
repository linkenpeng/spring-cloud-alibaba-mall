package com.intecsec.mall.order.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("mall_order")
public class Order {

    private Long id;

    private String orderSn;

    private Long userId;

    private Integer orderStatus;

    private Long priceAmount;

    private Long discountAmount;

    private Long couponAmount;

    private Long pointAmount;

    private Long deliveryFee;

    private Long payAmount;

    private Date gmtCreated;

    private Date gmtUpdate;

    @TableLogic
    private Byte deleteMark;
}