package com.cest.core.validator.rule;

import com.cest.common.util.ValidatorUtil;
import com.cest.core.validator.annotation.IsPhone;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by cestlavie on 2019/9/25.
 */
public class IsPhoneValidator implements ConstraintValidator<IsPhone,String> {

    private boolean required = false;

    //初始化 拿到注解
    @Override
    public void initialize(IsPhone constraintAnnotation) {
        //默认值
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //必输的
        if(required) {
            return ValidatorUtil.isMobile(value);
        }else {
            //非必输
            if(StringUtils.isEmpty(value)) {
                return true;
            }else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
