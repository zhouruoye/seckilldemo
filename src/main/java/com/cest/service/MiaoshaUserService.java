package com.cest.service;

import com.cest.common.util.CodeMsg;
import com.cest.common.util.MD5Util;
import com.cest.common.util.UUIDUtil;
import com.cest.core.exception.DefineException;
import com.cest.core.redis.RedisService;
import com.cest.core.redis.key.SeckillUserKey;
import com.cest.dao.SecKillUserMapper;
import com.cest.pojo.entity.SecKillUser;
import com.cest.pojo.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by cestlavie on 2019/9/23.
 */
@Service
public class MiaoshaUserService {

    @Autowired
    private SecKillUserMapper secKillUserMapper;

    /**
     * 登录 校验密码
     * @param loginVo
     * @return
     */
    public boolean login(HttpServletResponse response,LoginVo loginVo){
        if(loginVo == null){
            throw new DefineException(CodeMsg.SERVER_ERROR);
        }

        SecKillUser secKillUser = secKillUserMapper.queryUserById(loginVo.getMobile());

        //校验密码
        if(!MD5Util.inputPassToDBPass(loginVo.getPassword()).equals(secKillUser.getPassword())){
            throw new DefineException(CodeMsg.PASSWORD_ERROR);
        }

        //生成cookie uuid + 当前时间
        String token = UUIDUtil.uuid() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHH:mm:ss"));

        //添加token
        addCookie(response,token);
        return true;
    }

    @Autowired
    private RedisService redisService;

    private void addCookie(HttpServletResponse response, String token) {
        //redisService.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(SeckillUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
