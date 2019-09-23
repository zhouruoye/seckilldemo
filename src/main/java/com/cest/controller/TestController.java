package com.cest.controller;

import com.cest.dao.UserMapper;
import com.cest.entity.User;
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

    @RequestMapping("/mybatis")
    public String test() {
        List<User> users = userMapper.queryList();
        System.out.println(111);
        return "Hello Mybatis";
    }
}
