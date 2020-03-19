package com.demo.numcheck;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
@SpringBootApplication
@EnableBinding(NumProcessor.class)
@Log4j2
public class NumcheckApplication {
	public static void main(String[] args) {
		SpringApplication.run(NumcheckApplication.class, args);
		log.info("NumCheck has started");
	}

}
