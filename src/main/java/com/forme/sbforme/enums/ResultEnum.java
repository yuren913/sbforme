package com.forme.sbforme.enums;

public enum ResultEnum {
    ERROR_UNKNOWN(-1, "UNKNOWN ERROR"),
    SUCCESS(0,"SUCCESS"),
    ERROR_PRIMARY(200,"Primary School"),
    ERROR_SECONDARY(202,"Secondary School"),
    ;

    private Integer Code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        Code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return Code;
    }

    public String getMsg() {
        return msg;
    }
}
