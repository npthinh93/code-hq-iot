package com.codehq.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author thinhnguyen on 24/03/2022
 */
@Data
@AllArgsConstructor
public class Temperature {
    private String unit;
    private String value;
}
