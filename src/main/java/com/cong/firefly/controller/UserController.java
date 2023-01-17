package com.cong.firefly.controller;

import com.cong.firefly.common.R;
import com.cong.firefly.dto.UserDto;
import com.cong.firefly.pojo.User;
import com.cong.firefly.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private R register(@RequestBody @Valid UserDto userDto){
        userService.save(userDto);
        return new R();
    }

    @GetMapping("queryOneByUsername")
    private R queryOneByUsername(String username){
        User user = userService.getByUsername(username);
        return new R(user);
    }
}
