package com.cong.firefly.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

/**
 * @author cong
 * @date 2023/1/17 10:28
 */
@Data
@ToString
public class UserDto {

//    @ApiModelProperty("邮箱")
    @NotBlank
    private String email;

//    @ApiModelProperty("密码")
    @NotBlank
    private String password;
}
