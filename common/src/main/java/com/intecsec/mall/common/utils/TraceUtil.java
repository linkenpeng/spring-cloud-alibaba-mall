package com.intecsec.mall.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @description: 跟踪id
 * @author: peter.peng
 * @create: 2018-11-02 11:06
 **/
public class TraceUtil {
    private static final String logName = "traceId";

    private static ThreadLocal<String> tl = ThreadLocal.withInitial(() -> UUID.randomUUID().toString().replaceAll("-", ""));

    public static String currentTraceId() {
        String traceId = MDC.get(logName);
        return traceId;
    }

    public static void setTraceId(String end) {
        String traceId = UUID.randomUUID().toString().replaceAll("-", "");
        if (StringUtils.isNotEmpty(end)) {
            if (end.length() >= traceId.length()) {
                traceId = end;
            } else {
                int s = end.length();
                traceId = traceId.substring(0, traceId.length() - s) + end;
            }
        }

        putTraceId(traceId);
    }

    public static String putTraceId(String traceId) {
        if (StringUtils.isNotEmpty(traceId)) {
            tl.set(traceId);
        }

        String tid = tl.get();
        MDC.put(logName, tid);
        return tid;
    }

    public static void cleanTraceId() {
        tl.remove();
        MDC.remove(logName);
    }
}
