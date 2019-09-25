package com.cest.controller;

import com.cest.pojo.entity.SecKillUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String list(Model model,SecKillUser user) {
        model.addAttribute("user", user);
        return "goods_list";
    }
}
