package com.tazine.evo.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot 各类注解学习启动类
 *
 * @author frank
 * @date 2018/09/15
 */
@ComponentScan("com.tazine.evo")
@SpringBootApplication
public class EvoSpringbootAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoSpringbootAnnotationApplication.class, args);
	}
}
