package com.intecsec.mall.item.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("item")
public class Item {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String itemName;

    private Long categoryId;

    private Long defaultSkuId;

    private String itemImage;

    private String itemDesc;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdated;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteMark;
}