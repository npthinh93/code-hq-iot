package com.codehq.iot.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author thinhnguyen on 25/03/2022
 */
@Data
public class DeviceDTO implements Serializable {
    private String id;
    private String deviceId;
    private Double latitude;
    private Double longitude;
    private Set<DeviceDataDTO> data = new HashSet<>();
}
