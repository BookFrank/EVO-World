package com.tazine.evo.webflux.util.rest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HTTP 响应对象
 *
 * @author jiaer.ly
 * @date 2018/05/02
 */
@Data
@NoArgsConstructor
public class HttpResult<T> {

    private int code;
    private String msg;
    private T data;

    public HttpResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> HttpResult newInstance() {
        return new HttpResult();
    }

    public HttpResult(HttpAnswerCode answerCode){
        this.code = answerCode.getCode();
        this.msg = answerCode.getInfo();
    }

    public HttpResult(HttpAnswerCode answerCode, String msg){
        this.code = answerCode.getCode();
        this.msg = msg;
    }

    public HttpResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public HttpResult(HttpAnswerCode answerCode, T data){
        this.code = answerCode.getCode();
        this.msg = answerCode.getInfo();
        this.data = data;
    }
}
