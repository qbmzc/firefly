package com.cong.firefly.controller;

import com.cong.firefly.common.R;
import com.cong.firefly.dto.UserDto;
import com.cong.firefly.pojo.User;
import com.cong.firefly.service.UserService;
import com.cong.firefly.common.ObjectMapperEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * @author cong
 * @date 2023/1/17 10:34
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("register")
    private R register(@RequestBody @Valid UserDto userDto) {
        userService.save(userDto);
        return new R();
    }

    @PostMapping("login")
    private R login(@RequestBody @Valid UserDto userDto, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        User user = userService.login(userDto);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 30);
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        String userStr = ObjectMapperEnum.INSTANCE.getObjectMapper().writeValueAsString(user);
        session.setAttribute(token, userStr);
        Map<String, String> tokenMap = Map.of("token", token);
        return new R(tokenMap);
    }

    @GetMapping("queryOneByUsername")
    private R queryOneByUsername(String username) {
        User user = userService.getByUsername(username);
        return new R(user);
    }
}
