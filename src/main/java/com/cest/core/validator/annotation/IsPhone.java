package com.cest.core.validator.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义校验器
 * Created by cestlavie on 2019/9/25.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { })
public @interface IsPhone {

    boolean required() default true;

    String message() default "{手机号码格式错误}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
