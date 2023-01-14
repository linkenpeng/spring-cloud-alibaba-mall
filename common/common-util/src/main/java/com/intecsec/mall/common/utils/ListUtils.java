package com.intecsec.mall.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-14 22:26
 **/
public class ListUtils {

    public static List<Long> idsToList(String idsStr) {
        List<Long> ids = new ArrayList<>();
        if(StringUtils.isNotEmpty(idsStr)) {
            String idSplit[] = StringUtils.split(idsStr, ",");
            for(String id : idSplit) {
                ids.add(Long.parseLong(id));
            }
        }
        return ids;
    }
}
