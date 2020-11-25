package com.jiang.missyou.dto.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = TokenPasswordValidator.class)
public @interface TokenPassword {
    int max() default 32;

    int min() default  6;

    String message() default "密码不符合要求";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
