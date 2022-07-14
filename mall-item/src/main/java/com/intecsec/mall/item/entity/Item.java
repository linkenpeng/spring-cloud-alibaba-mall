package com.intecsec.mall.item.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Item {

    private Long id;

    private String itemName;

    private Long itemPrice;

    private String itemImage;

    private String itemDesc;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;
}