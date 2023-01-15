package com.intecsec.mall.item.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("item_sku")
public class ItemSku {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String skuName;

    private Long itemId;

    private Long skuPrice;

    private Long skuStock;

    private String skuImage;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdated;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteMark;
}