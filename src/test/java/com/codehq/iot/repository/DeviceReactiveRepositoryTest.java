package com.codehq.iot.repository;

import com.codehq.iot.domain.Device;
import com.codehq.iot.domain.DeviceData;
import com.codehq.iot.domain.Temperature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Instant;
import java.util.Set;

/**
 * @author thinhnguyen on 24/03/2022
 */
@ExtendWith(SpringExtension.class)
@DataMongoTest(excludeAutoConfiguration = {EmbeddedMongoAutoConfiguration.class})
public class DeviceReactiveRepositoryTest {

    @Autowired
    private DeviceReactiveRepository deviceReactiveRepository;

    @Test
    public void findById_NonExistedIdGiven_ShouldReturnEmpty() {
        Mono<Device> byId = deviceReactiveRepository.findById("test-01");
        StepVerifier
                .create(byId)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    public void saveOne_NewDeviceGiven_ShouldReturnDeviceThatEqualWithNewDevice() {
        Device d = new Device();
        d.setDeviceId("xyz123");
        d.setLatitude(41.25);
        d.setLongitude(-120.9762);
        DeviceData dd = new DeviceData();
        dd.setHumidity(123);
        dd.setTimestamp(Instant.now());
        dd.setTemperature(new Temperature("C", "23.3"));
        d.setData(Set.of(dd));
        Mono<Device> save = deviceReactiveRepository.save(d);
        StepVerifier
                .create(save)
                .consumeNextWith(s -> {
                    Assertions.assertNotNull(s.getDeviceId());
                })
                .verifyComplete();
    }
}
