package com.cong.firefly.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author cong
 * @date 2023/1/17 09:57
 */
@Data
@Entity
@ToString
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String password;

//    private String phone;
//
//    private String email;

    private String salt;

    private Integer status;

    private LocalDate createTime;

    private LocalDate updateTime;

    private Integer isDeleted;
}
