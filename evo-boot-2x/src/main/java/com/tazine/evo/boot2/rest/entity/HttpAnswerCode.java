package com.tazine.evo.boot2.rest.entity;

import lombok.Getter;

/**
 * HTTP 响应码
 *
 * @author jiaer.ly
 * @date 2018/05/03
 */
@Getter
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
     * 超出 Sentinel 限流配置，拒绝请求
     */
    REQUEST_BLOCKED(3, "Exceeds the rate limit and rejects the request"),

    /**
     * 当前URL未授权
     */
    UNAUTHORIZED_URI(4, "unauthorized uri"),

    /**
     * 访问失败
     */
    BAD_REQUEST(400, "Bad Request"),

    /**
     * 未知错误（各类异常抛出时，替换 info 字段）
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private int code;

    private String info;

    HttpAnswerCode(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
