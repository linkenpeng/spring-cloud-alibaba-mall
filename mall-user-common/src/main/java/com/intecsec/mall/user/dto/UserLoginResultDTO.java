package com.intecsec.mall.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-16 23:16
 **/
@Data
public class UserLoginResultDTO implements Serializable {

    private static final long serialVersionUID = -5476406287148372217L;
    
    private String accessToken;

    private String userName;

    private String nickName;

    private String avatar;

    private Integer role;
}
