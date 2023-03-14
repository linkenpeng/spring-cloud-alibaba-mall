package com.intecsec.mall.dict.test.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-14 22:47
 **/
@Data
public class UserData {

    @ExcelProperty(value = "用户编号", index = 0)
    private int uid;

    @ExcelProperty(value = "用户名称", index = 1)
    private String username;

}
