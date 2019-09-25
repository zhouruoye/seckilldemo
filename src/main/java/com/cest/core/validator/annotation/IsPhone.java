package com.cest.core.validator.annotation;

import com.cest.core.validator.rule.IsPhoneValidator;

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
@Constraint(validatedBy = {IsPhoneValidator.class})
public @interface IsPhone {

    //默认不能为空
    boolean required() default true;

    //如果校验不通过 默认提示
    String message() default "{手机号码格式错误}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
