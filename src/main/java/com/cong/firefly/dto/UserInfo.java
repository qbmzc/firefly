package com.cong.firefly.dto;

import lombok.Data;

@Data
public class UserInfo {
    
    private Long id;

    private String username;

    private String avatar;

    private String token;
}
