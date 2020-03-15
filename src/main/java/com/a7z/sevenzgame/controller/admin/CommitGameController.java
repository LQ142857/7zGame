package com.a7z.sevenzgame.controller.admin;

import com.a7z.sevenzgame.entity.vo.GameCommit;
import com.a7z.sevenzgame.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 提交游戏页面controller
 * 提交全部信息(除图片信息)给数据库
 *
 *
 * @author lq
 * @create 2020/3/14-15:32
 */
@Controller
@RequestMapping("/commitGame")
public class CommitGameController {
    @Autowired
    GamesService gamesService;

    /**
     * 提交全部信息(除图片信息)给数据库
     *
     * @param gameCommit
     * @return
     */
    @RequestMapping("/submit")
    @ResponseBody
    public void submitGame(GameCommit gameCommit) {
        System.out.println(gameCommit);
//        gamesService.addOne(gameCommit);



    }



}
