package com.tazine.evo.boot2.rest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * 统一 JSON 返回
 *
 * @author jiaer.ly
 * @date 2019/10/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface EvoJsonResponse {
}
