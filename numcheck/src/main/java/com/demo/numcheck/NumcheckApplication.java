package com.demo.numcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(NumProcessor.class)
public class NumcheckApplication {
	private static final Logger log = LoggerFactory.getLogger(NumcheckApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(NumcheckApplication.class, args);
		log.info("NumCheck has started");
	}

}
