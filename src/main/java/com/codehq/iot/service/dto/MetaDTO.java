package com.codehq.iot.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author thinhnguyen on 26/03/2022
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetaDTO {

    private int code;
    private String message;

}
