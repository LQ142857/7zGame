package com.a7z.sevenzgame.service.impl;

import com.a7z.sevenzgame.domain.GamesDao;
import com.a7z.sevenzgame.entity.po.Games;
import com.a7z.sevenzgame.entity.vo.GameCommit;
import com.a7z.sevenzgame.service.GamesService;
import com.a7z.sevenzgame.utils.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @create 2020/3/14-21:54
 */
@Service
public class GamesServiceImpl implements GamesService {
    @Autowired
    GamesDao gamesDao;

    @Override
    public void addOne(GameCommit gameCommit) {
        Games games = new Games();
        games.setName(gameCommit.getName());
        games.setCompany(gameCommit.getCompany());
        games.setPrice(gameCommit.getPrice());
        games.setDiscount(gameCommit.getDiscount());
        games.setPubdate("" + DateKit.getUnixTimeLong());
        games.setDescribes(gameCommit.getDescribe());
        String cover = gameCommit.getCover();
        cover = cover.substring(cover.lastIndexOf("/") + 1).toLowerCase();
        games.setCover(cover);
        games.setVideourl(gameCommit.getVideourl());

        gamesDao.addOne(games);
    }
}
