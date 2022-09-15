package com.coding404.myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BootmywebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootmywebApplication.class, args);
	}

}
