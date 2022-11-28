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

    @TableLogic
    private Byte deleteMark;
}