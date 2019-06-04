package com.tazine.evo.boot.conf;

import lombok.Data;

/**
 * Primary数据库配置，
 *
 * @author frank
 * @date 2019/06/03
 */
@Data
public class DruidProperties {

    private String mapperLocations;
    private String typeAliasesPackage;
    private String basePackage;
    private String plugins;
}
