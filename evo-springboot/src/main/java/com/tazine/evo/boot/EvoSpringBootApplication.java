package com.tazine.evo.boot;

import com.tazine.evo.boot.config.property.EvoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot2.0 实践
 *
 * @author frank
 * @date 2018/11/11
 */
@EnableConfigurationProperties({EvoProperties.class})
@ServletComponentScan
@SpringBootApplication
public class EvoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoSpringBootApplication.class, args);
	}
}
