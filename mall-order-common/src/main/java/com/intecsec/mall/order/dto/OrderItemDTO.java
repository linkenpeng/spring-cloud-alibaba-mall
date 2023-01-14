package com.intecsec.mall.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 19:42
 **/
@Data
public class OrderItemDTO implements Serializable {

    private static final long serialVersionUID = 7736501051774467112L;

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

    private Byte deleteMark;

}
