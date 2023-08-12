package com.likelion.thinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ThinkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkerApplication.class, args);
	}

}
