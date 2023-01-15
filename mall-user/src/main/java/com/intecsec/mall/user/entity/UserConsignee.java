package com.intecsec.mall.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_consignee")
public class UserConsignee {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String province;

    private String city;

    private String area;

    private String address;

    private String consigneeName;

    private String mobile;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Byte deleteMark;
}