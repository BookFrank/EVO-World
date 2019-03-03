package com.tazine.evo.boot.entity.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * HTTP 响应码
 *
 * @author jiaer.ly
 * @date 2018/05/03
 */
public enum HttpAnswerCode {

    /**
     * 请求成功，错误码为 0
     */
    SUCCESS(0, "SUCCESS"),

    /**
     * 签名校验失败
     */
    SIGN_FAILED(1, "Signature verification failed"),

    /**
     * 参数错误（缺失参数、参数类型错误等）
     */
    PARAMS_ERROR(2, "Params error, please check the params"),

    /**
     * 访问失败
     */
    ACCESS_FAIL(3, "Fail to access the resource"),

    /**
     * 未知错误（各类异常抛出时，替换 info 字段）
     */
    UNEXPECTED_ERROR(4, "Unexpected error")
    ;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String info;

    HttpAnswerCode(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
