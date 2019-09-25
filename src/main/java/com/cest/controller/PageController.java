package com.cest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * Created by cestlavie on 2019/9/23.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/to_list")
    public String list() {
        return "goods_list";
    }
}
