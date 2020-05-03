package com.tazine.evo.webflux.util.rest.entity;

import lombok.Getter;
import org.springframework.http.HttpStatus;

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
    SUCCESS(200, "SUCCESS"),

    /**
     * 访问失败
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "Bad Request"),

    /**
     * 未授权的访问
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "Unauthorized Request"),

    /**
     * 未知错误（各类异常抛出时，替换 info 字段）
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");

    private int code;

    private String info;

    HttpAnswerCode(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
