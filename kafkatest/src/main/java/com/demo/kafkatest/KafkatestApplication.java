package com.demo.kafkatest;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
public class KafkatestApplication {

	private static Logger log = LoggerFactory.getLogger(KafkatestApplication.class);

	public static void main(String[] args) {
			SpringApplication.run(KafkatestApplication.class, args);
			log.info("Kafkatest has started");
	}

	@Bean
	public Supplier<Number> numberSupplier() {
		return() -> {
			RandomDataGenerator rdg = new RandomDataGenerator();
			int num = rdg.nextInt(1, 100);
			Number number = new Number(UUID.randomUUID().toString(), num);
			log.info("Number {} is {}, UUID = {}", number.getNumber(), number.getType(), number.getUuid());
			return number;
		};
	}
}
