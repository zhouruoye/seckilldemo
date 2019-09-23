package com.cest.controller;

import com.cest.util.CodeMsg;
import com.cest.util.Result;
import com.cest.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by cestlavie on 2019/9/23.
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/do_login")
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        //登录
        return Result.error(CodeMsg.MOBILE_ERROR);
    }
}