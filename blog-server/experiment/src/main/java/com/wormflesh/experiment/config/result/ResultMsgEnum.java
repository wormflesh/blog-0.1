package com.wormflesh.experiment.config.result;

/**
 * @Description: 返回结果状态消息枚举
 * @Author: wormflesh
 * @Date: Created in 23:05 2022/3/14
 */
public enum ResultMsgEnum {
    SUCCESS(200, "成功"),
    FAIL(0, "失败"),
    AUTH_ERROR(502, "授权失败!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!"),
    DATABASE_OPERATION_FAILED(504, "数据库操作失败");
    private int code;
    private String message;

    ResultMsgEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}