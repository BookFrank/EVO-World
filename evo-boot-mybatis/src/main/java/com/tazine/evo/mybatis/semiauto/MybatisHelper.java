package com.tazine.evo.mybatis.semiauto;

/**
 * TDDL 配置获取助件
 *
 * @author jiaer.ly
 * @date 2018/04/12
 */
public class MybatisHelper {

    public static org.apache.ibatis.session.Configuration getMybatisSettings() {
        org.apache.ibatis.session.Configuration mybatisSettings = new org.apache.ibatis.session.Configuration();
        mybatisSettings.setMapUnderscoreToCamelCase(true);
        return mybatisSettings;
    }
}
