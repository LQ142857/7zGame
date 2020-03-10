package com.a7z.sevenzgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lq
 * @create 2020/3/4-16:39
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        System.out.println("dddddd");
        return "/index/index";
    }
}
