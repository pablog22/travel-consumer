package com.afkl.travel.exercise.travelconsumer;

import com.afkl.travel.exercise.travelconsumer.service.LocationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelConsumerApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(LocationService locationService) throws Exception {
		return args -> {
			locationService.printAirportsFromUSA();

		};
	}

}
