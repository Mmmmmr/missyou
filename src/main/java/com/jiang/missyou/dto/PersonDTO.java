package com.jiang.missyou.dto;

import com.jiang.missyou.validators.PasswordEqual;
import lombok.Data;
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
