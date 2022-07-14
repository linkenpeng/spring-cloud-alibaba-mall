package com.intecsec.mall.order.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderConsignee {
    private Long id;

    private Long orderId;

    private Long userId;

    private String province;

    private String city;

    private String area;

    private String address;

    private String consigneeName;

    private String mobile;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;
}