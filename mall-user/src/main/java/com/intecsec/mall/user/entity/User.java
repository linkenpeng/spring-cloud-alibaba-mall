package com.intecsec.mall.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;

    private String password;

    private String salt;

    private Integer age;

    private String nickName;

    private String avatar;

    private Integer role;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdated;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteMark;
}