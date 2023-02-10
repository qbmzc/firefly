package com.cong.firefly.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

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

   private String phone;

   private String email;

    private String salt;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;
}
