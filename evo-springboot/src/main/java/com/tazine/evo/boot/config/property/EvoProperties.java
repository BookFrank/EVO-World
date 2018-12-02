package com.tazine.evo.boot.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * EvoProperties
 *
 * @author frank
 * @date 2018/12/01
 */
@Data
@ConfigurationProperties(prefix = "evo")
public class EvoProperties {

    private String module;

    /**
     * 随机字符串
     */
    private String value;

    /**
     * 随机int
     */
    private int number;

    private long bignumber;

    private int test1;

    private int test2;
}
