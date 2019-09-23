package com.cest.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginVo {
	
	@NotNull
	private String mobile;
	
	@NotNull
	@Length(min=32)
	private String password;
	
	@Override
	public String toString() {
		return "LoginVo [mobile=" + mobile + ", password=" + password + "]";
	}
}
