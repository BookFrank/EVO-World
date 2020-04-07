package com.tazine.evo.db.mybatis.boot.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TDDL 配置获取助件
 *
 * @author jiaer.ly
 * @date 2018/04/12
 */
public class MybatisHelper {

    private static final Logger logger = LoggerFactory.getLogger(MybatisHelper.class);

    public static org.apache.ibatis.session.Configuration getMybatisSettings() {
        org.apache.ibatis.session.Configuration mybatisSettings = new org.apache.ibatis.session.Configuration();
        mybatisSettings.setMapUnderscoreToCamelCase(true);
        return mybatisSettings;
    }

    public static Resource[] getResource(String mapperLocations) {
        String[] locationArr = mapperLocations.split(",");
        List<Resource> resourceList = new ArrayList<>();
        for (int i = 0; i < locationArr.length; i++) {
            String location = locationArr[i].trim();
            try {
                Resource[] resources = new PathMatchingResourcePatternResolver().getResources(location);
                resourceList.addAll(Arrays.asList(resources));
            } catch (Exception e) {
                logger.error("init mapper resource exception, mapperLocations={}", mapperLocations, e);
            }
        }
        return resourceList.toArray(new Resource[0]);
    }

    ///**
    // * 从 Environment 中获取 TDDL 配置并转为对象
    // *
    // * @param environment 环境配置
    // * @return MultiTddlProperties
    // */
    //public static MultiTddlProperties getProperties(ConfigurableEnvironment environment) {
    //    MultiTddlProperties properties = new MultiTddlProperties();
    //    MutablePropertySources propertySources = environment.getPropertySources();
    //    new RelaxedDataBinder(properties, TddlConfigConstants.PREFIX)
    //        .bind(new PropertySourcesPropertyValues(propertySources));
    //    return properties;
    //}
    //
    //public static Interceptor[] getPlugins(String plugins) {
    //    if (StringUtils.isEmpty(plugins)) {
    //        return null;
    //    }
    //    String[] pluginArr = plugins.split(TddlConfigConstants.DELIMITER);
    //    Interceptor[] interceptors = new Interceptor[pluginArr.length];
    //    for (int i = 0; i < pluginArr.length; i++) {
    //        String className = pluginArr[i];
    //        try {
    //            interceptors[i] = (Interceptor)Class.forName(className.trim()).newInstance();
    //        } catch (Exception e) {
    //            logger.error("init mybatis filter exception, className={}", className, e);
    //        }
    //    }
    //    return interceptors;
    //}
}
