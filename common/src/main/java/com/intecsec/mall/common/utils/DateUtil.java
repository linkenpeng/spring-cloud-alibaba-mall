package com.intecsec.mall.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-24 17:10
 **/
public class DateUtil {

    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDHHmmss = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHmmssSSS = "yyyyMMddHHmmssSSS";

    public static final String YYYY_MM_DD_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    // 时间转时间戳
    public static Long converDateToTimestamp(Date date) {
        Long timeStamp = date.getTime() / 1000L;
        return timeStamp;
    }

    // 时间戳转字符串(秒)
    public static String converTimestampToString(Long timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_mm_ss);
        return sdf.format(new Date(timeStamp * 1000L));
    }
}