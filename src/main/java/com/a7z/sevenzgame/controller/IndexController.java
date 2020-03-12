package com.a7z.sevenzgame.controller;

import com.a7z.sevenzgame.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lq
 * @create 2020/3/4-16:39
 */
@Controller
@RequestMapping("/test")
public class IndexController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String index() {
        System.out.println("-----------------------------");
        System.out.println(userDao.findAll());
        return "/index/index";
    }
}
