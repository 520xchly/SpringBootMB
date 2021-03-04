package com.vsofo.cspmodel.commonmodels;

/**
 * 公共 返回码
 */
public enum ResultCode {

    SUCCESS(200, "操作成功"), FAILED(500, "操作异常");

    private long code = 200;
    private String message = "";

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultCode(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
