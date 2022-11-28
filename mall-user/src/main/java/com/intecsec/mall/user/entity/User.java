package com.intecsec.mall.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("mall_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;

    private String password;

    private Integer age;

    private String nickName;

    private String avatar;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteMark;
}