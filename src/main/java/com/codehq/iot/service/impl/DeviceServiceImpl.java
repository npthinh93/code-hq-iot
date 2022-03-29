package com.codehq.iot.service.impl;

import com.codehq.iot.domain.Device;
import com.codehq.iot.repository.DeviceReactiveRepository;
import com.codehq.iot.service.DeviceService;
import com.codehq.iot.service.dto.DeviceDTO;
import com.codehq.iot.service.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Instant;

/**
 * @author thinhnguyen on 24/03/2022
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceReactiveRepository deviceReactiveRepository;
    private DeviceMapper deviceMapper;

    @Autowired
    public void setDeviceReactiveRepository(DeviceReactiveRepository deviceReactiveRepository) {
        this.deviceReactiveRepository = deviceReactiveRepository;
    }

    @Autowired
    public void setDeviceMapper(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    @Override
    public void create(DeviceDTO dto) {
        deviceReactiveRepository.findByDeviceId(dto.getDeviceId())
                .log()
                .publishOn(Schedulers.boundedElastic())
                .doOnSuccess(sub -> {
                    if (sub == null) {
                        deviceReactiveRepository.save(deviceMapper.toEntity(dto)).subscribe();
                    } else {
                        if (!CollectionUtils.isEmpty(dto.getData())) {
                            Device device = deviceMapper.toEntity(dto);
                            sub.getData().addAll(device.getData());
                            deviceReactiveRepository.save(sub).subscribe();
                        }
                    }
                })
                .subscribe();

    }

    @Override
    public Mono<Device> findByTime(String deviceId, Instant startTime, Instant endTine) {
        return deviceReactiveRepository.findByDeviceIdWithDataTemperature(deviceId, startTime, endTine);
    }
}
