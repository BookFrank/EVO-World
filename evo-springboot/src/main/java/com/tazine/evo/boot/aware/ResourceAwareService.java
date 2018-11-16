package com.tazine.evo.boot.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * AwareService，实现 BeanNameAware 和 ResourceLoaderAware 接口，获得 Bean 名称和资源加载的服务
 *
 * @author frank
 * @date 2018/09/26
 */
@Service
public class ResourceAwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

//    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

//    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() {
        System.out.println("Bean 的名称为：" + beanName);
        // 如果文件在 Resources 目录下，直接 classpath:文件名 即可
        Resource resource = loader.getResource("classpath:aware.txt");
        try {
            System.out.println("ResourceLoader 加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
