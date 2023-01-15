package com.intecsec.mall.item.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-14 22:19
 **/
@Data
public class ItemSkuDTO implements Serializable {

    private static final long serialVersionUID = -3318116304499950668L;

    private Long id;

    private String skuName;

    private Long itemId;

    private Long skuPrice;

    private Long skuStock;

    private String skuImage;

    private Integer status;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Byte deleteMark;
}
