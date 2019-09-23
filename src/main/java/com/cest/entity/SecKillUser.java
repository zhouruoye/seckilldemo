package com.cest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 秒杀用户表
 * Created by cestlavie on 2019/9/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecKillUser {

    //id 手机号
    private String id;

    //昵称
    private String nickName;

    //密码
    private String password;

    private String salt;

    //图片
    private String head;

    //注册时间
    private Date registerTime;

    //上次登录时间
    private Date lastLoginTime;

    //登录次数
    private int loginCount;
}
