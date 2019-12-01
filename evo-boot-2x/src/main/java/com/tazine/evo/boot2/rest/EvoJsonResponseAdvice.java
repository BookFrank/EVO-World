package com.tazine.evo.boot2.rest;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.boot2.rest.entity.HttpResult;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * TisJsonResponseAdvice
 *
 * @author jiaer.ly
 * @date 2019/10/11
 */
@RestControllerAdvice
public class EvoJsonResponseAdvice implements ResponseBodyAdvice<Object> {

    private static final Class<? extends Annotation> ANNOTATION_TYPE = EvoJsonResponse.class;

    /**
     * 判断类或者方法是否使用了 @TisJsonResponse
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE) || returnType
            .hasMethodAnnotation(ANNOTATION_TYPE);
    }

    /**
     * 当类或者方法使用了 @TisJsonResponse 就会调用这个方法
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletResponse httpServletResponse = ((ServletServerHttpResponse)response).getServletResponse();
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        //试探请求过期时间
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        //允许请求头中加入Authorization
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type");
        //允许发送cookie
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "false");

        // 防止重复包裹
        if (body instanceof HttpResult) {
            return body;
        }
        if (body instanceof String){
            HttpResult result = RestResponseBuilder.buildSuccessResponse((String)body);
            return JSON.toJSONString(result);
        }else {
            return RestResponseBuilder.buildSuccessResponse(body);
        }
    }
}
