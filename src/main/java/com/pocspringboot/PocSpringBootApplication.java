package com.pocspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pocspringboot.adapters.driven")
public class PocSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringBootApplication.class, args);
	}

}
