package com.intecsec.mall.common.response;

import com.intecsec.mall.common.enums.ResponseEnum;
import com.intecsec.mall.common.utils.TraceUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description: 输出Api结果
 * @author: peter.peng
 * @create: 2018-11-02 11:04
 **/
@Getter
@Setter
public class ApiResponse<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private long totalCount;

    private String traceId;

    private void init() {
        try {
            this.traceId = TraceUtil.currentTraceId();
        } catch (Exception e) {

        }
    }

    public ApiResponse() {

    }

    public ApiResponse(T data) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
        this.data = data;
        this.init();
    }

    public ApiResponse(T data, long totalCount) {
        this(data);
        this.totalCount = totalCount;
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.init();
    }


    public ApiResponse(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.init();
    }
}
