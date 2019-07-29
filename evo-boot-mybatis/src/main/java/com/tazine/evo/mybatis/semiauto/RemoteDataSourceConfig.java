package com.tazine.evo.mybatis.semiauto;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author jiaer.ly
 * @date 2019/07/12
 */
//@Configuration
//@MapperScan(basePackages = "com.tazine.evo.mybatis.multi.remote", sqlSessionTemplateRef  = "remoteSqlSessionTemplate")
public class RemoteDataSourceConfig {

    @Bean(name = "remoteDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.remote")
    public DataSource remoteDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "remoteSqlSessionFactory")
    public SqlSessionFactory remoteSqlSessionFactory(@Qualifier("remoteDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);


        // Mybatis XML 配置
        /*加载mybatis全局配置文件*/
        //bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
        /*加载所有的mapper.xml映射文件*/
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));


        return bean.getObject();
    }

    @Bean(name = "remoteTransactionManager")
    //@Primary
    public DataSourceTransactionManager remoteTransactionManager(@Qualifier("remoteDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "remoteSqlSessionTemplate")
    //@Primary
    public SqlSessionTemplate remoteSqlSessionTemplate(@Qualifier("remoteSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
