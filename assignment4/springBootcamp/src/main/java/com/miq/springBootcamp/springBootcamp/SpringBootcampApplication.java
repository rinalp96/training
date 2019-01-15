package com.miq.springBootcamp.springBootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootcampApplication.class, args);
	}

}