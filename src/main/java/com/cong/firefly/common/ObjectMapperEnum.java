package com.cong.firefly.common;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author cong
 * @date 2023/1/17 13:56
 */
public enum ObjectMapperEnum {
    INSTANCE;

    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
