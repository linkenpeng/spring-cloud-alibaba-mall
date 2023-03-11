package com.intecsec.mall.dict.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("dict")
public class Dict {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private String name;

    private String value;

    private String dictCode;

    private Boolean hasChildren;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdated;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteMark;
}