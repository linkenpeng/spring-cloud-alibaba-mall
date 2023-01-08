package com.intecsec.mall.item.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-07 16:24
 **/
@Data
public class ItemCategoryDTO implements Serializable {

    private static final long serialVersionUID = 3448159083093351410L;

    private Long id;

    private String name;

    private Long parentId;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;
}
