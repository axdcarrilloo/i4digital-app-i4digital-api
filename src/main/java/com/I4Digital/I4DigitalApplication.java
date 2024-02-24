package com.I4Digital;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class I4DigitalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(I4DigitalApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("I4DigitalApplication.class - run() -> Iniciando servicios de I4Digital...!");
	}
}
