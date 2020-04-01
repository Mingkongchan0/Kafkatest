package com.demo.digitcheck;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(NumProcessor.class)
@Log4j2
public class DigitcheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitcheckApplication.class, args);
		log.info("DigitcheckAppication has started");
	}

}
