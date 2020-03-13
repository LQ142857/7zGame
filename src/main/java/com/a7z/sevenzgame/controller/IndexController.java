package com.a7z.sevenzgame.controller;


import com.a7z.sevenzgame.entity.vo.GameCommit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lq
 * @create 2020/3/4-16:39
 */
@Controller
@RequestMapping("/test")
public class IndexController {


    @RequestMapping("/show")
    public String index() {
        System.out.println("-----------------------------");
        return "/show/index";
    }

    @RequestMapping("/admin")
    public String admin() {
        System.out.println("-----------------------------");
        System.out.println();
        return "/Admin/submitGame";
    }


    @RequestMapping("/submitGame")
    public String submitGame(GameCommit gameCommit) {
        System.out.println(gameCommit);
        return "/show/index";
    }


}