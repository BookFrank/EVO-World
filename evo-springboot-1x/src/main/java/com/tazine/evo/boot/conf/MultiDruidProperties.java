package com.tazine.evo.boot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * MultiDruidProperties
 *
 * @author frank
 * @date 2019/06/03
 */
@ConfigurationProperties(prefix = "tazine.druid")
public class MultiDruidProperties extends DruidProperties {

    private Map<String, String> mapperLocationss;
    private Map<String, String> typeAliasesPackages;
    private Map<String, String> basePackages;
    private Map<String, String> pluginss;

    public Map<String, String> getPluginss() {
        return pluginss;
    }

    public void setPluginss(Map<String, String> pluginss) {
        this.pluginss = pluginss;
    }

    public Map<String, String> getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(Map<String, String> basePackages) {
        this.basePackages = basePackages;
    }

    public void setMapperLocationss(Map<String, String> mapperLocationss) {
        this.mapperLocationss = mapperLocationss;
    }

    public Map<String, String> getMapperLocationss() {
        return mapperLocationss;
    }

    public Map<String, String> getTypeAliasesPackages() {
        return typeAliasesPackages;
    }

    public void setTypeAliasesPackages(Map<String, String> typeAliasesPackages) {
        this.typeAliasesPackages = typeAliasesPackages;
    }

    /**
     * 将读取到的 properties 转换为 TddlProperties 对象
     *
     * @return map
     */
    public Map<String, DruidProperties> getPropertiesMap() {
        if (null == basePackages || basePackages.size() == 0) {
            return Collections.emptyMap();
        }
        Map<String, DruidProperties> propertiesMap = new HashMap<String, DruidProperties>();
        for (String name : basePackages.keySet()) {
            DruidProperties properties = new DruidProperties();
            if (mapperLocationss != null && mapperLocationss.containsKey(name)){
                properties.setMapperLocations(mapperLocationss.get(name));
            }
            if (typeAliasesPackages != null && typeAliasesPackages.containsKey(name)) {
                properties.setTypeAliasesPackage(typeAliasesPackages.get(name));
            }
            properties.setBasePackage(basePackages.get(name));
            if (pluginss != null && pluginss.containsKey(name)) {
                properties.setPlugins(pluginss.get(name));
            }
            propertiesMap.put(name, properties);
        }
        return propertiesMap;
    }
}
