package com.intecsec.mall.order;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderConsigneeDTO implements Serializable {

    private static final long serialVersionUID = -759272277997219808L;

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