package com.tazine.evo.boot.conf;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * DruidAutoConfiguration
 *
 * @author frank
 * @date 2019/06/03
 */
@Configuration
@EnableConfigurationProperties(MultiDruidProperties.class)
public class DruidAutoConfiguration {

}
