package com.wormflesh.experiment.config.result;

import lombok.Data;

/**
 * @Description: 统一返回结果Result
 * @Author: wormflesh
 * @Date: Created in 22:59 2022/3/14
 */
@Data
public class Result<T> {

    private int code;

    private String message;

    private T data;

    public Result() {}
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultMsgEnum.SUCCESS.getCode());
        result.setMessage(ResultMsgEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 失败
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(int code, String message) {
        return new Result(code, message);
    }
}