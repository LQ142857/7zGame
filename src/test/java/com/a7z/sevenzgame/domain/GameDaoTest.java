package com.a7z.sevenzgame.domain;

import com.a7z.sevenzgame.entity.po.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lq
 * @create 2020/3/13-10:16
 */
@SpringBootTest
public class GameDaoTest {
    @Autowired
    GamesDao gamesDao;

    @Test
    void addGameTest() {
//        Game game = new Game();
//        game.setName("name");
//        game.setCompany("company");
//        game.setPrice("111");
//        game.setDiscount("1");
//
//        game.setCover("===");
//        game.setDescribes("describe");
//        game.setVideourl("videourl");
//        gamesDao.addOne(game);
    }

    @Test
    void getGidByNameTest() {
//        System.out.println(gamesDao.getGidByName("DJMAX RESPECT V"));
    }

    @Test
    void testFindOne(){
//        Game one = gamesDao.findOne(10000);
//        System.out.println(one);

    }




}
