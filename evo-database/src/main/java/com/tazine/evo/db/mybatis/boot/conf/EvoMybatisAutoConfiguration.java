package com.tazine.evo.db.mybatis.boot.conf;

import com.tazine.evo.db.mybatis.boot.EvoMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * TDDL 多数据源自动配置
 *
 * @author jiaer.ly
 * @date 2018/04/12
 */
@Configuration
@AutoConfigureAfter({DataSourceAutoConfiguration.class})
public class EvoMybatisAutoConfiguration implements EnvironmentAware {

    @Primary
    @Bean(name = "sqlSessionFactory")
    @ConditionalOnClass(DataSource.class)
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("");
        factoryBean.setConfiguration(MybatisHelper.getMybatisSettings());
        //factoryBean.setMapperLocations();
        //factoryBean.setPlugins();
        return factoryBean.getObject();
    }

    @Bean(name = "mapperScannerConfigurer")
    //@ConditionalOnProperty("spring.tddl.basePackage")
    public MapperScannerConfigurer mapperScannerConfigurer() throws Exception {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        configurer.setBasePackage("com.tazine.evo.db.mybatis.boot");
        configurer.setAnnotationClass(EvoMapper.class);
        System.err.println("mapperScannerConfigurer");
        return configurer;
    }

    /**
     * 系统启动时执行，将当前环境变量注入
     *
     * @param environment 配置
     */
    @Override
    public void setEnvironment(Environment environment) {

    }
}
