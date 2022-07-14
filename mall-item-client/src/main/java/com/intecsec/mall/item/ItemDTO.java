package com.intecsec.mall.item;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 19:00
 **/
@Data
public class ItemDTO implements Serializable {

    private static final long serialVersionUID = -2090373826486633392L;

    private Long id;

    private String itemName;

    private Long itemPrice;

    private String itemImage;

    private String itemDesc;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;

}
