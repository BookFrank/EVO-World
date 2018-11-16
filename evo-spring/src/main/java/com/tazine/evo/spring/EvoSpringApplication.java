package com.tazine.evo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Spring 各类接口与特性实践。
 *
 * @author frank
 * @date 2018/10/31
 */
//@ServletComponentScan
@SpringBootApplication
public class EvoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoSpringApplication.class, args);
	}
}