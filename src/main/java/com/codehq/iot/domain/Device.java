package com.codehq.iot.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * @author thinhnguyen on 24/03/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Device extends AbstractAuditingEntity {

    @Id
    private String id;

    private String deviceId;
    private Double latitude;
    private Double longitude;
    private Set<DeviceData> data;

}
