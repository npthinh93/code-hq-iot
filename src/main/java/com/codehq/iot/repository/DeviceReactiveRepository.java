package com.codehq.iot.repository;

import com.codehq.iot.domain.Device;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * @author thinhnguyen on 24/03/2022
 */
@Repository
public interface DeviceReactiveRepository extends ReactiveMongoRepository<Device, String> {

    Mono<Device> findByDeviceId(String deviceId);

    @Query("{ $and:[{'deviceId':?0},{'data':{'timestamp':{$gte: ?1,$lte:?2}}}]}")
    Mono<Device> findByDeviceIdWithDataTemperature(String deviceId, Instant start, Instant end);

}
