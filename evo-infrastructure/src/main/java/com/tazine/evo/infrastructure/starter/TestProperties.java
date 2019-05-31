package com.tazine.evo.infrastructure.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TestProperties
 *
 * @author frank
 * @date 2019/05/30
 */
@Data
@ConfigurationProperties(prefix = "test")
public class TestProperties {

    /**
     * 属性名称，默认值为 frank
     */
    private String name = "frank";
}
