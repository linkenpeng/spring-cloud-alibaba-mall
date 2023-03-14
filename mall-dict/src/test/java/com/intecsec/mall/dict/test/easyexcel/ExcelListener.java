package com.intecsec.mall.dict.test.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.intecsec.mall.common.utils.JsonUtils;

import java.util.Map;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-14 23:01
 **/
public class ExcelListener extends AnalysisEventListener<UserData> {

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头：" + JsonUtils.toJson(headMap));
    }

    @Override
    public void invoke(UserData userData, AnalysisContext analysisContext) {
        System.out.println(JsonUtils.toJson(userData));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
