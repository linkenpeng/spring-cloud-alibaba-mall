package com.intecsec.mall.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("mall_user_consignee")
public class UserConsignee {

    private Long id;

    private Long userId;

    private String province;

    private String city;

    private String area;

    private String address;

    private String consigneeName;

    private String mobile;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;
}