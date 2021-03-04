package com.vsofo.cspmodel.commonmodels;

import lombok.Data;

/**
 * 公共返回对象
 */
@Data
public class JsonResult<T> {
    private long code;
    private String message;
    private T data;

    public JsonResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public JsonResult(ResultCode resultCode, String message, T data) {
        this.code = resultCode.getCode();
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     */
    public static <E> JsonResult<E> success(E data) {
        return new JsonResult<E>(ResultCode.SUCCESS, data);
    }

    /**
     * 成功返回结果
     */
    public static <E> JsonResult<E> success(String message, E data) {
        return new JsonResult<E>(ResultCode.SUCCESS, message, data);
    }

    /**
     * 失败返回结果
     */
    public static <E> JsonResult<E> failed(E data) {
        return new JsonResult<E>(ResultCode.FAILED, data);
    }

    /**
     * 失败返回结果
     */
    public static <E> JsonResult<E> failed(String message, E data) {
        return new JsonResult<E>(ResultCode.FAILED, message, data);
    }

}
