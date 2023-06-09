package com.URLvalidation.Validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidationApplication {



	private static final Logger logger = LoggerFactory.getLogger(ValidationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ValidationApplication.class, args);
		logger.debug("This is a debug message");
		logger.info("This is a info message");
		logger.warn("This is a warn message");
		logger.error("This is a error message");
	}





//	public void run(ApplicationArguments applicationArguments) throws Exception {
//		logger.debug("Debugging log");
//		logger.info("Info log");
//		logger.warn("Hey, This is a warning!");
//		logger.error("Oops! We have an Error. OK");
//		logger.fatal("Damn! Fatal error. Please fix me.");
//	}
}

