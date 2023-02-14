package com.cong.firefly.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cong.firefly.dto.UserDto;
import com.cong.firefly.service.UserService;

import jakarta.annotation.PostConstruct;

/**
 * @author cong
 * @date 2023/1/17 15:10
 */
@Component
public class UserInit {

    @Autowired
    private UserService userService;

    /**
     * 初始化测试账户
     */
    @PostConstruct
    public void initUser() {
        if (null == userService.getByEmail("mxlyzc@163.com")) {
            UserDto userDto = new UserDto();
            userDto.setEmail("mxlyzc@163.com");
            userDto.setPassword("Snow@0417");
            userService.save(userDto);
        }
    }
}
