package com.cong.firefly.common;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author cong
 * @date 2023/1/17 13:56
 */
public enum ObjectMapperEnum {
    INSTANCE;

    private final ObjectMapper objectMapper;

    private ObjectMapperEnum() {
        objectMapper = new ObjectMapper();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
