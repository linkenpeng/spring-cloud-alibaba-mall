package com.intecsec.mall.item.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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

    private String skuImage;

    private Integer status;

    private Date gmtCreated;

    private Date gmtUpdated;

    @TableLogic
    private Byte deleteMark;
}