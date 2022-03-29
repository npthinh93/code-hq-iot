package com.codehq.iot.domain;

import lombok.Data;

import java.time.Instant;

/**
 * @author thinhnguyen on 24/03/2022
 */
@Data
public class DeviceData {
    private Integer humidity;
    private Temperature temperature;
    private Instant timestamp;
}