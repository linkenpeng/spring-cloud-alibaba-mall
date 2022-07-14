package com.intecsec.mall.order.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderItem {
    private Long id;

    private Long orderId;

    private Long itemId;

    private Long itemPrice;

    private Integer itemNum;

    private String itemName;

    private Long actualPrice;

    private Long couponAmount;

    private Long pointAmount;

    private Long discountAmount;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;
}