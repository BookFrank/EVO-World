package com.tazine.evo.boot.util;

import com.tazine.evo.boot.entity.HttpResult;
import com.tazine.evo.boot.entity.enums.HttpAnswerCode;

/**
 * Rest 风格响应建造器
 *
 * @author frank
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
}
