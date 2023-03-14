package com.intecsec.mall.dict.test.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-14 22:49
 **/
public class TestWriteRead {

    public static void main(String[] args) {
        // write();
        read();
    }

    public static void read() {
        String fileName = "/Users/pengzhenxian/01.xlsx";
        EasyExcel.read(fileName, UserData.class, new ExcelListener()).sheet().doRead();
    }

    public static void write() {
        String fileName = "/Users/pengzhenxian/01.xlsx";

        List<UserData> userData = Lists.newArrayList();
        for(int i = 0; i < 10; i++) {
            UserData data = new UserData();
            data.setUid(i);
            data.setUsername("lucy" + i);
            userData.add(data);
        }

        EasyExcel.write(fileName, UserData.class).sheet("用户信息")
                .doWrite(userData);
    }
}
