package com.junhyuk.mysnail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MysnailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysnailApplication.class, args);
	}
}
