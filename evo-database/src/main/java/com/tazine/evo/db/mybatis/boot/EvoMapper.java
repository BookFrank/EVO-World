package com.tazine.evo.db.mybatis.boot;

import java.lang.annotation.*;

/**
 * @author jiaer.ly
 * @date 2020/04/07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface EvoMapper {
}
