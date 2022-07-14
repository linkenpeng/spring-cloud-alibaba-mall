package com.intecsec.mall.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-03-22 19:44
 **/
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -6736152204831551496L;

    private Long id;

    private String userName;

    private String password;

    private String nickName;

    private String avatar;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;

    private Integer userServicePort;
}
