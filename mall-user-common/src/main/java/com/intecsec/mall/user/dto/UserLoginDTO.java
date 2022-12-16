package com.intecsec.mall.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-16 23:16
 **/
@Data
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = -1L;

    private String accessToken;

    private String userName;

    private String nickName;

    private String avatar;

    private Integer role;
}
