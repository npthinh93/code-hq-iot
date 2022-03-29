package com.codehq.iot.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author thinhnguyen on 25/03/2022
 */
@Data
public class TemperatureDTO implements Serializable {
    private String unit;
    private String value;
}
