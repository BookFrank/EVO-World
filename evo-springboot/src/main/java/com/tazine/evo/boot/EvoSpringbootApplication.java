package com.tazine.evo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class EvoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoSpringbootApplication.class, args);
	}
}
