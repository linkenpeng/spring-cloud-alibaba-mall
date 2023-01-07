package com.intecsec.mall.item.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("mall_item")
public class Item {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String itemName;

    private Long categoryId;

    private Long itemPrice;

    private String itemImage;

    private String itemDesc;

    private Integer status;

    private Date gmtCreated;

    private Date gmtUpdate;

    @TableLogic
    private Byte deleteMark;
}