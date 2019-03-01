package com.tazine.evo.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesLoad
 *
 * @author frank
 * @date 2019/03/01
 */
public class PropertiesLoad {

    public static void main(String[] args) throws IOException {

        Properties prop = PropertiesLoaderUtils.loadProperties(new ClassPathResource("test.properties"));

        System.out.println(prop.getProperty("kobe"));

    }

}
