package com.codehq.iot.service.mapper;

import com.codehq.iot.domain.Device;
import com.codehq.iot.service.dto.DeviceDTO;
import org.mapstruct.Mapper;

/**
 * @author thinhnguyen on 25/03/2022
 */
@Mapper(componentModel = "spring")
public interface DeviceMapper extends EntityMapper<DeviceDTO, Device> {

    DeviceDTO toDto(Device reasonMessage);

    Device toEntity(DeviceDTO reasonMessageDTO);

    default Device fromId(String id) {
        if (id == null) {
            return null;
        }
        Device device = new Device();
        device.setId(id);
        return device;
    }
}
