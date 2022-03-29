package com.codehq.iot.controller;

import com.codehq.iot.domain.Device;
import com.codehq.iot.service.DeviceService;
import com.codehq.iot.service.dto.DeviceDTO;
import com.codehq.iot.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * @author thinhnguyen on 24/03/2022
 */
@RestController
@RequestMapping("/api/v1/devices")
@RequiredArgsConstructor
public class DeviceController {

    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    private final DeviceService deviceService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DeviceDTO dto) {
        logger.info("[DEVICE-CONSUMPTION] Request: {}", JsonUtils.toJson(dto));
        deviceService.create(dto);
    }

    @GetMapping("/get/{deviceId}")
    public ResponseEntity<Mono<Device>> findById(@PathVariable("deviceId") String deviceId,
                                                 @RequestParam("start") Instant startTime,
                                                 @RequestParam("start") Instant endTime) {
        logger.info("[DEVICE-CONSUMPTION] Device: {} - Start: {} - End: {}", deviceId, startTime, endTime);
        Mono<Device> result = deviceService.findByTime(deviceId, startTime, endTime);
        return new ResponseEntity<>(result, result != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
