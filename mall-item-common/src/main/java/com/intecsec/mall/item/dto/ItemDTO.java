package com.intecsec.mall.item.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 19:00
 **/
@Data
public class ItemDTO implements Serializable {

    private static final long serialVersionUID = -2090373826486633392L;

    private Long id;

    private String itemName;

    private Long categoryId;

    private Long defaultSkuId;

    private String itemImage;

    private String itemDesc;

    private Integer status;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Byte deleteMark;

    private ItemCategoryDTO itemCategory;
}
