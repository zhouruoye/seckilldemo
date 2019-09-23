package com.cest.controller;

import com.cest.dao.UserMapper;
import com.cest.entity.User;
import com.cest.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cestlavie on 2019/8/29.
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/mybatis")
    public String testMybatis() {
        List<User> users = userMapper.queryList();
        System.out.println(111);
        return "Hello Mybatis";
    }

    @RequestMapping("/redis")
    public String testRedis() {
        boolean set = redisService.set("nameTest", "tingting");

        boolean name = redisService.isExists("nameTest");

        String nameTest = redisService.get("nameTest", String.class);

        System.out.println(111);
        return "Hello Redis";
    }
}
