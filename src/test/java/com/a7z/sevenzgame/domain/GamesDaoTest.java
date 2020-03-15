package com.a7z.sevenzgame.domain;

import com.a7z.sevenzgame.entity.po.Games;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lq
 * @create 2020/3/13-10:16
 */
@SpringBootTest
public class GamesDaoTest {
    @Autowired
    GamesDao gamesDao;

    @Test
    void addGameTest() {
        Games game = new Games();
        game.setName("name");
        game.setCompany("company");
        game.setPrice("111");
        game.setDiscount(1);
        game.setPubdate("pubdate");
        game.setCover("===");
        game.setDescribes("describe");
        game.setVideourl("videourl");
        gamesDao.addOne(game);
    }

    @Test
    void getGidByNameTest() {
        System.out.println(gamesDao.getGidByName("DJMAX RESPECT V"));
    }




}
