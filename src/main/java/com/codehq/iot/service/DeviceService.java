package com.codehq.iot.service;

import com.codehq.iot.domain.Device;
import com.codehq.iot.service.dto.DeviceDTO;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * @author thinhnguyen on 24/03/2022
 */
public interface DeviceService {

    void create(DeviceDTO dto);

    Mono<Device> findByTime(String deviceId, Instant startTime, Instant endTine);

}
