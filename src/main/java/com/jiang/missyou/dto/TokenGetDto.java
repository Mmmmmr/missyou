package com.jiang.missyou.dto;

import com.jiang.missyou.core.enumeration.LoginType;
import com.jiang.missyou.dto.validators.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenGetDto {
    @NotBlank(message="account不能为空")
    private String account;

    @TokenPassword(max=30, message = "{token.password}")
    private String password;

    private LoginType type;
}
