package com.tazine.evo.boot.beanext.factory;

import com.tazine.evo.boot.beanext.NioCar;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 使用 @Component + FactoryBean接口 创建 Bean
 *
 * @author frank
 * @date 2018/10/31
 */
@Component
public class FactoryBeanTest implements FactoryBean<NioCar> {

    @Override
    public NioCar getObject() throws Exception {
        // 可以通过此方式将第三方 Jar 包中的类创建为一个 Bean 来进行管理
        // 并可在创建 Bean 之前对 bean 进行一系列的配置工作
        // e.g. ES TransportClient
        return new NioCar();
    }

    @Override
    public Class<?> getObjectType() {
        return NioCar.class;
    }
}
