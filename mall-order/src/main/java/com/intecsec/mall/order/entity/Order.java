package com.intecsec.mall.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order_trade")
public class Order {

    /**
     * AUTO(0), 自动增长
     * NONE(1),
     * INPUT(2), 需要设置
     * ASSIGN_ID(3), 雪花算法 19 位随机值， 默认值
     * ASSIGN_UUID(4)，
     */
    @TableId(type = IdType.AUTO)
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

    private Date gmtUpdated;

    @TableLogic
    private Byte deleteMark;
}