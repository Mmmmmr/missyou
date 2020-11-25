package com.jiang.missyou.dto;

import com.jiang.missyou.dto.validators.PasswordEqual;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PasswordEqual
public class PersonDTO {
    private int age;

    private String name;

    private String password1;
    private String password2;

}
