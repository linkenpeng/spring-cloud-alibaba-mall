package com.intecsec.mall.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserConsigneeDTO implements Serializable {

    private static final long serialVersionUID = 8594118915051275212L;

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