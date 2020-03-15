package com.a7z.sevenzgame.domain;

import com.a7z.sevenzgame.entity.po.GameConfigure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lq
 * @create 2020/3/13-10:33
 */
@SpringBootTest
public class GameConfigureDaoTest {
    @Autowired
    GameConfigureDao gameConfigureDao;

    @Test
    void addOneTest() {
        GameConfigure gameConfigure = new GameConfigure();
        gameConfigure.setGid("gid");
        gameConfigure.setSystem("system");
        gameConfigure.setCpu("cpu");
        gameConfigure.setGpu("gpu");
        gameConfigure.setRam("ram");
        gameConfigure.setRom("rom");
        gameConfigure.setDirectx("11");
        gameConfigure.setNet(1);

        gameConfigureDao.addOne(gameConfigure);

    }


}
