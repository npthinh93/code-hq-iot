package com.codehq.iot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author thinhnguyen on 25/03/2022
 */
@Configuration
@EnableWebFlux
public class WebFluxConfiguration implements WebFluxConfigurer {
}
