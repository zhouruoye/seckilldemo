package com.cest.service;

import com.cest.dao.SecKillUserMapper;
import com.cest.pojo.entity.SecKillUser;
import com.cest.core.exception.DefineException;
import com.cest.common.util.CodeMsg;
import com.cest.common.util.MD5Util;
import com.cest.pojo.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean login(LoginVo loginVo){
        if(loginVo == null){
            throw new DefineException(CodeMsg.SERVER_ERROR);
        }

        SecKillUser secKillUser = secKillUserMapper.queryUserById(loginVo.getMobile());

        //校验密码
        if(!MD5Util.inputPassToDBPass(loginVo.getPassword()).equals(secKillUser.getPassword())){
            throw new DefineException(CodeMsg.PASSWORD_ERROR);
        }
        return true;
    }
}
