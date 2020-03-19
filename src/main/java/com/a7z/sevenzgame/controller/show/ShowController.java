package com.a7z.sevenzgame.controller.show;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lq
 * @create 2020/3/4-16:39
 */
@Controller
@RequestMapping("/index")
public class ShowController {


    @RequestMapping("/game")
    public String index() {
        System.out.println("gid");
        return "/show/game";
    }






}
