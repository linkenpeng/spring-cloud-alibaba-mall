package com.intecsec.mall.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 注册登录前端传参
 * @author: peter.peng
 * @create: 2022-12-16 23:16
 **/
@Data
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = -5824026399940591286L;

    private String userName;

    private String password;

    private Integer role;
}
