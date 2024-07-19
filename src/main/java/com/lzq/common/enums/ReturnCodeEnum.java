package com.lzq.common.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReturnCodeEnum {
    RC999("999", "操作失败"),
    RC200("200", "success"),
    RC400("400", "fail"),
    RC401("401", "匿名用户访问无权限资源时的异常"),
    RC500("500", "系统异常，请稍后再试"),
    INVALID_TOKEN("2001", "访问令牌不合法"),
    ACCESS_DENIED("2003", "没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED("1001", "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR("1002", "用户名或密码错误"),
    BUSINESS_ERROR("1004", "业务逻辑异常"),
    UNSUPPORTED_GRANT_TYPE("1003", "不支持的认证模式");

    private final String code;
    private final String message;

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ReturnCodeEnum getReturnCodeEnum(String code) {
        return Arrays.stream(ReturnCodeEnum.values()).filter(e -> e.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
