package com.intecsec.mall.dict.dto;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-04 23:22
 **/
@Data
public class DictDTO {
    private Long id;

    private Long parentId;

    private String name;

    private String value;

    private String dictCode;

    private boolean hasChildren;

    private Date gmtCreated;

    private Date gmtUpdated;

    private Integer deleteMark;
}
