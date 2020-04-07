package com.tazine.evo.db;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TDDL 配置Bean
 *
 * @author jiaer.ly
 * @date 2018/04/12
 */
@ConfigurationProperties(prefix = "spring.tddl")
public class EvoMybatisProperties {

    private String mapperLocations;
    private String typeAliasesPackage;
    private String basePackage;
    private String plugins;

    public String getPlugins() {
        return plugins;
    }

    public void setPlugins(String plugins) {
        this.plugins = plugins;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }
}
