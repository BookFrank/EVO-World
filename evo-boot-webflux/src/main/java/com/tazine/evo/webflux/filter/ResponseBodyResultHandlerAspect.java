package com.tazine.evo.webflux.filter;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.tazine.evo.webflux.util.rest.RestResponseBuilder;
import com.tazine.evo.webflux.util.rest.entity.HttpResult;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.result.method.InvocableHandlerMethod;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 采用 AOP 拦截 ResponseBodyResultHandler 来替换响应
 *
 * @author jiaer.ly
 * @date 2020/05/01
 */
@Aspect
@Component
@ConditionalOnClass(name = {"org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler"})
public class ResponseBodyResultHandlerAspect {

    private static final Set<String> WHITE_URI_LIST = Sets.newHashSet(
        "/checkpreload.htm"
    );

    @SneakyThrows
    @Around(value = "execution(* org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler.handleResult(..)) && args(exchange, result)", argNames = "point,exchange,result")
    public Object handleResult(ProceedingJoinPoint point, ServerWebExchange exchange, HandlerResult result) {
        // 0. 判断是不是 JSON 响应，是 JSON 响应并且不在白名单内再针对性的处理
        Object returnValue = result.getReturnValue();

        boolean isRest = AnnotationUtils.isAnnotationDeclaredLocally(RestController.class, ((InvocableHandlerMethod) result.getHandler()).getBean().getClass());
        ResponseBody responseBody = AnnotationUtils.findAnnotation(((InvocableHandlerMethod) result.getHandler()).getMethod(), ResponseBody.class);

        String uri = exchange.getRequest().getPath().value();
        if (!WHITE_URI_LIST.contains(uri)) {
            if (isRest || null != responseBody) {
                // 1. 获取返回对象的 Class 类型
                Class returnClz = result.getReturnType().getRawClass();

                // 2. 根据返回值类型做分类处理
                if (returnClz == Mono.class) {
                    final Mono responseMono = ((Mono)result.getReturnValue())
                        .map(
                            responseValue -> responseValue instanceof HttpResult ? responseValue
                                : RestResponseBuilder.buildSuccessResponse(responseValue)
                        );
                    returnValue = responseMono;
                } else if (returnClz == Flux.class) {
                    List<Object> list = Lists.newArrayList();
                    final Flux responseFlux = ((Flux)result.getReturnValue());
                    if (null != responseFlux) {
                        responseFlux.subscribe(o -> list.add(o));
                        returnValue = RestResponseBuilder.buildSuccessResponse(list);
                    }
                } else if (returnClz == HttpResult.class) {
                    returnValue = result.getReturnValue();
                } else if (returnClz == String.class){
                    returnValue = RestResponseBuilder.buildSuccessResponse((String)result.getReturnValue());
                    returnValue = JSON.toJSONString(returnValue);
                } else {
                    returnValue = RestResponseBuilder.buildSuccessResponse(result.getReturnValue());
                }
            }
        }

        //// 1. 首先判断响应对象是不是异步对象，就是带不带 Mono 或 Flux
        //String typeName = result.getReturnType().getType().getClass().getName();
        //String name = result.getReturnValue().getClass().getSimpleName();
        //
        //// 使用 hasGenerics 判断返回值是否为泛型对象
        //boolean b = result.getReturnType().hasGenerics();
        //System.out.println("has generics " + b);
        //
        //// rawClass instance Mono
        //System.out.println("rawClass == Mono.class " + (result.getReturnType().getRawClass() == Mono.class));
        //
        //// 返回值为 Mono<T> 时，rawClass name = reactor.core.publisher.Mono
        //String canonicalName = result.getReturnType().getRawClass().getCanonicalName();
        //System.err.println("canonicalName - " + canonicalName);
        //
        //String srcName = result.getReturnType().getSource().getClass().getCanonicalName();
        //System.err.println("srcName - " + srcName);
        //
        //System.err.println(" -----" + (result.getReturnValue() instanceof NbaPlayer));
        //
        //System.err.println("clzName - " + name);
        //System.err.println("typeName - " + typeName);

        return point.proceed(Arrays.asList(
            exchange,
            new HandlerResult(result.getHandler(), returnValue, result.getReturnTypeSource())
        ).toArray());
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString("hi"));
    }
}
