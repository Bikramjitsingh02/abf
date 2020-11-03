package com.pragra.abfapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class AbfApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(AbfApiApplication.class, args);
	}

}
