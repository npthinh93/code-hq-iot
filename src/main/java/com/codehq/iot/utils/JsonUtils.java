package com.codehq.iot.utils;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author thinhnguyen on 26/03/2022
 */
public class JsonUtils {

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    public static final JavaTimeModule DEFAULT_TIME_MODULE = new JavaTimeModule();
    private static final HashMap<Module, ObjectMapper> mapperMap = new HashMap<>();

    static {
        mapperMap.put(DEFAULT_TIME_MODULE, new ObjectMapper().registerModule(DEFAULT_TIME_MODULE));
    }

    public static String toJson(Object data) {
        return toJson(data, DEFAULT_TIME_MODULE);
    }

    public static String toJson(Object data, Module module) {
        try {
            ObjectMapper mapper = getMapper(module);
            return mapper.writeValueAsString(data);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    private static ObjectMapper getMapper(Module module) {
        ObjectMapper mapper = mapperMap.get(module);
        if (mapper == null) {
            mapper = new ObjectMapper().registerModule(module);
        }
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
