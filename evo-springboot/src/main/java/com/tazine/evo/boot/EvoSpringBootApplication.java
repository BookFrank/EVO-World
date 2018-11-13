package com.tazine.evo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot2.0 实践
 *
 * @author frank
 * @date 2018/11/11
 */
@ServletComponentScan
@SpringBootApplication
public class EvoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoSpringBootApplication.class, args);
	}
}
