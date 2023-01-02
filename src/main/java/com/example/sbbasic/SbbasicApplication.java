package com.example.sbbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class SbbasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbbasicApplication.class, args);
	}

}
