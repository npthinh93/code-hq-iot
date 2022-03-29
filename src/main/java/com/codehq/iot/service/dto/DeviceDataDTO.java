package com.codehq.iot.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author thinhnguyen on 25/03/2022
 */
@Data
public class DeviceDataDTO implements Serializable {
    private Integer humidity;
    private TemperatureDTO temperature;
    private Instant timestamp = Instant.now();
}
