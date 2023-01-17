package com.cong.firefly.service;

import com.cong.firefly.dto.UserDto;
import com.cong.firefly.jpa.UserRepo;
import com.cong.firefly.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

/**
 * @author cong
 * @date 2023/1/17 10:08
 */
@Slf4j
@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * 新建一个用户并保存
     *
     * @param userDto
     */
    public void save(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        String salt = RandomStringUtils.randomAlphabetic(10);
        user.setSalt(salt);
        String hashPassword = DigestUtils.md5DigestAsHex((userDto.getPassword() + salt).getBytes(StandardCharsets.UTF_8));
        user.setPassword(hashPassword);
        user.setCreateTime(new Date());
        user.setStatus(1);
        user.setIsDeleted(0);
        userRepo.save(user);
    }


    /**
     * 根据用户名称查询记录
     * @param username
     * @return
     */
    public User getByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        Optional<User> optional = userRepo.findOne(Example.of(user));
        return optional.orElse(null);
    }

    /**
     * 删除
     *
     * @param id
     */
    public int delete(Long id) {
        User file = new User();
        file.setId(id);
        file.setIsDeleted(1);
        userRepo.save(file);
        return 1;
    }

    /**
     * 登陆
     * @param userDto
     * @return
     */

    public User login(UserDto userDto) {
        User user = this.getByUsername(userDto.getUsername());
        if (null==user){
            throw new RuntimeException("用户名或者密码错误");
        }
        //密码加盐计算密文
        String hexPassword = DigestUtils.md5DigestAsHex((userDto.getPassword() + user.getSalt()).getBytes(StandardCharsets.UTF_8));
        if (StringUtils.equals(user.getPassword(),hexPassword)){
            return user;
        }else {
            throw new RuntimeException("用户名或者密码错误");
        }
    }
}
