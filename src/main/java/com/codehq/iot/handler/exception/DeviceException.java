package com.codehq.iot.handler.exception;

/**
 * @author thinhnguyen on 26/03/2022
 */
public class DeviceException extends AbstractRuntimeException {

    public DeviceException(String code, String message, Object data) {
        super(code, message, data);
    }

}
