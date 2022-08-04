package com.sparta.assignment041;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Assignment041Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment041Application.class, args);
	}

}
