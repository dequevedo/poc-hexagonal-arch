package com.pocspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pocspringboot.repository")
public class PocSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringBootApplication.class, args);
	}

}
