package com.ajay.webtest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
@SpringBootApplication
@EnableWebFlux
@EnableR2dbcRepositories
@Slf4j
public class WebtestApplication {

	public static void main(String[] args) {
		MDC.put("service-name","async-service");
		MDC.put("correlation-id","startup-correlation");
		SpringApplication.run(WebtestApplication.class, args);

	}

}


