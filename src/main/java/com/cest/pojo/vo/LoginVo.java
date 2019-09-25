package com.cest.pojo.vo;

import com.cest.core.validator.annotation.IsPhone;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginVo {
	
	@NotNull(message = "手机号不能为空")
	@IsPhone
	private String mobile;
	
	@NotNull(message = "密码不能为空")
	@Length(min = 32,max = 32)
	private String password;
}
