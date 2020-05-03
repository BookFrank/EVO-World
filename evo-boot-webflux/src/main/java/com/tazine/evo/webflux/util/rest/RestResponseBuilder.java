package com.tazine.evo.webflux.util.rest;

import com.tazine.evo.webflux.util.rest.entity.HttpAnswerCode;
import com.tazine.evo.webflux.util.rest.entity.HttpResult;

/**
 * Rest 风格响应建造器
 *
 * @author jiaer.ly
 * @date 2018/05/03
 */
public class RestResponseBuilder {

    /**
     * 生成成功请求对象
     *
     * @return HttpResult
     */
    public static HttpResult buildSuccessResponse() {
        return new HttpResult<>(HttpAnswerCode.SUCCESS);
    }

    /**
     * 生成成功请求对象
     *
     * @param data T
     * @return HttpResult
     */
    public static <T> HttpResult<T> buildSuccessResponse(T data) {
        return new HttpResult<>(HttpAnswerCode.SUCCESS, data);
    }

    /**
     * 生成错误请求对象
     *
     * @param data T
     * @return HttpResult
     */
    public static <T> HttpResult<T> buildExceptionResponse(Integer code, String msg, T data) {
        return new HttpResult<>(code, msg, data);
    }

    /**
     * 生成错误请求对象
     *
     * @param answerCode HttpAnswerCode
     * @return HttpResult
     */
    public static HttpResult buildErrorResponse(HttpAnswerCode answerCode) {
        return new HttpResult(answerCode);
    }

    /**
     * 生成错误请求对象
     *
     * @param answerCode Enum
     * @param msg        错误信息
     * @return HttpResult
     */
    public static HttpResult buildErrorResponse(HttpAnswerCode answerCode, String msg) {
        return new HttpResult(answerCode, msg);
    }

    /**
     * 生成错误返回对象
     *
     * @param data T
     * @return HttpResult
     */
    public static <T> HttpResult<T> buildErrorResponse(HttpAnswerCode answerCode, T data) {
        return new HttpResult<>(answerCode, data);
    }

    /**
     * 生成服务器端错误返回对象
     *
     * @param data T
     * @return HttpResult
     */
    public static <T> HttpResult<T> buildServerErrorResponse(T data) {
        return new HttpResult<>(HttpAnswerCode.INTERNAL_SERVER_ERROR, data);
    }

    /**
     * 生成限流响应对象
     *
     * @return HttpResult
     */
    public static HttpResult buildUnauthorizedResponse() {
        return new HttpResult(HttpAnswerCode.UNAUTHORIZED);
    }
}
