package com.codehq.iot.handler.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author thinhnguyen on 26/03/2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AbstractRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private Object data;

    public AbstractRuntimeException(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
