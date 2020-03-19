package com.demo.kafkatest;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.function.Supplier;
@SpringBootApplication
@Log4j2
public class KafkatestApplication {
	public static void main(String[] args) {
			SpringApplication.run(KafkatestApplication.class, args);
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
