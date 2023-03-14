package com.intecsec.mall.dict.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-14 23:22
 **/
@Data
public class DictVO {

    @ExcelProperty(value = "id", index = 0)
    private Long id;

    @ExcelProperty(value = "上级id", index = 1)
    private Long parentId;

    @ExcelProperty(value = "名称", index = 2)
    private String name;

    @ExcelProperty(value = "值", index = 3)
    private String value;

    @ExcelProperty(value = "编码", index = 4)
    private String dictCode;

    @ExcelProperty(value = "是否有下级数据", index = 5)
    private Boolean hasChildren;

    @ExcelProperty(value = "创建时间", index = 6)
    private Date gmtCreated;

    @ExcelProperty(value = "更新时间", index = 7)
    private Date gmtUpdated;

    @ExcelProperty(value = "删除标识", index = 8)
    private Integer deleteMark;
}
