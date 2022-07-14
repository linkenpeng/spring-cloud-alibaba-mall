package com.intecsec.mall.common.Response;

import com.intecsec.mall.common.Enums.ResponseEnum;
import com.intecsec.mall.common.utils.TraceUtil;

/**
 * @description: 输出Json
 * @author: peter.peng
 * @create: 2018-11-02 11:04
 **/
public class ApiResponse<T> {
        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
        public String getTraceId() {
            return traceId;
        }
        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }

        public ApiResponse(int code,String msg){
            this.code = code;
            this.msg = msg;
            this.traceId = TraceUtil.currentTraceId();
        }

        public ApiResponse(ResponseEnum responseEnum){
            this.code = responseEnum.getCode();
            this.msg = responseEnum.getMsg();
            this.traceId = TraceUtil.currentTraceId();
        }

        public Long getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Long totalCount) {
            this.totalCount = totalCount;
        }

        private int code;
        private String msg;
        private T data;
        private Long totalCount;
        private String traceId;
}
