package com.example.MultipleDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class MultipleDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatabaseApplication.class, args);
	}

}
