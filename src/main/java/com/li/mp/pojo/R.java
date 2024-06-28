package com.li.mp.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName R
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/27 16:52
 * @Version 1.0
 */
@Data
public class R<T>  implements Serializable {

    private static final long serialVersionUID = 1L;
    // 返回状态码
    private Integer  code;
    // 返回体
    private T data;
    // 返回信息
    private String  msg;

    public static <T> R<T> ok() {
        return returnResult(REnum.SUCCESS.getCode(), null, REnum.SUCCESS.getDesc());
    }

    public static <T> R<T> ok(T data) {
        return returnResult(REnum.SUCCESS.getCode(), data, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return returnResult(REnum.SUCCESS.getCode(), data, msg);
    }

    public static <T> R<T> fail() {
        return returnResult(REnum.FAIL.getCode(), null, REnum.FAIL.getDesc());
    }

    public static <T> R<T> fail(T data) {
        return returnResult(REnum.FAIL.getCode(), data, null);
    }

    public static <T> R<T> fail(T data, String msg) {
        return returnResult(REnum.FAIL.getCode(), data, msg);
    }

    // 统一返回信息
    public static <T> R<T> returnResult(Integer code, T data, String msg) {
        final R<T> result = new R<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

}
