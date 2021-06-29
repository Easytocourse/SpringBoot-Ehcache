package com.easytocourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RestServicewithcachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServicewithcachingApplication.class, args);
	}

}
