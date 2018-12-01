package com.cdl.demo.enums;

public enum ResultEnum {
    ERROR(-1,"错误"),
    SUCCESS(0,"成功"),
    MESSGAE_EMPTY(1, "消息记录为空")
    ;

    private Integer code;

    private String  msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
