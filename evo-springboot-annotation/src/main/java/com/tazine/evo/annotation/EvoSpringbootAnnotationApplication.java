package com.tazine.evo.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.tazine.evo")
@SpringBootApplication
public class EvoSpringbootAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoSpringbootAnnotationApplication.class, args);
	}
}
