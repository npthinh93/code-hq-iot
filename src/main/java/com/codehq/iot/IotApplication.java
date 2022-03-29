package com.codehq.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class IotApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotApplication.class, args);
    }

}
