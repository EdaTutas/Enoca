package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Enocav2Application {
	private static final Logger logger = LoggerFactory.getLogger(Enocav2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Enocav2Application.class, args);
		logger.info("This is a info message");
		logger.debug("This is a debug message");
		logger.warn("This is a warn message");
		logger.error("This is a error message");
	}

}
