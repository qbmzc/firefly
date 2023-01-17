package com.cong.firefly.jpa;

import com.cong.firefly.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author cong
 * @date 2023/1/17 10:07
 */
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
