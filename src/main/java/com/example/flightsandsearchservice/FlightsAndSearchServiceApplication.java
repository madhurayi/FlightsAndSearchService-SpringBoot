package com.example.flightsandsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlightsAndSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsAndSearchServiceApplication.class, args);
	}

}
