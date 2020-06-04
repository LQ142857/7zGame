package com.a7z.sevenzgame.service.impl;

import com.a7z.sevenzgame.domain.CompanyDao;
import com.a7z.sevenzgame.domain.GamesDao;
import com.a7z.sevenzgame.domain.ImagesDao;
import com.a7z.sevenzgame.domain.TagsDao;
import com.a7z.sevenzgame.entity.po.Game;
import com.a7z.sevenzgame.entity.pojo.Cart;
import com.a7z.sevenzgame.entity.vo.GameCommit;
import com.a7z.sevenzgame.entity.vo.get.*;
import com.a7z.sevenzgame.service.GamesService;
import com.a7z.sevenzgame.utils.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lq
 * @create 2020/3/14-21:54
 */
@Service
public class GamesServiceImpl implements GamesService {
    @Autowired
    GamesDao gamesDao;
    @Autowired
    ImagesDao imagesDao;
    @Autowired
    TagsDao tagsDao;
    @Autowired
    CompanyDao companyDao;

    @Override
    public void addOne(GameCommit gameCommit) {
//        Game game = new Game();
//        game.setName(gameCommit.getName());
//        game.setCompany(gameCommit.getCompany());
//        game.setPrice(gameCommit.getPrice());
//        game.setDiscount(gameCommit.getDiscount());
//
//        game.setDescribes(gameCommit.getDescribe());
//        String cover = gameCommit.getCover();
//        cover = cover.substring(cover.lastIndexOf("/") + 1).toLowerCase();
//        game.setCover(cover);
//        game.setVideourl(gameCommit.getVideourl());
//
//        gamesDao.addOne(game);
    }

    @Override
    public GameDetailGet findOne(int gid) {
        GameDetailGet json = new GameDetailGet();
        Game gameInfo = gamesDao.findOne(gid);
        gameInfo.setCompanyName(companyDao.queryName(gameInfo.getCompany()));
        json.setTime(DateKit.formatDateByUnixTime(gameInfo.getTime(), "yyyy-MM-dd"));
        json.setInfo(gameInfo);
        json.setImgArr(imagesDao.queryEffectByGid(gid, 1));
        json.setTags(tagsDao.queryAllTagsByGid(gid));
        return json;
    }

    @Override
    public void addHot(int gid, int num) {
        num += gamesDao.queryHot(gid);
        gamesDao.changeHot(gid, num);
    }

    @Override
    public Cart findCart(int gid) {
        return gamesDao.queryCart(gid);
    }

    @Override
    public String findName(int gid) {
        return gamesDao.queryGameName(gid);
    }

    @Override
    public String findBg(int gid) {
        return gamesDao.queryBg(gid);
    }

    @Override
    public String findConfiguration(int gid) {
        return gamesDao.queryConfigure(gid);
    }

    @Override
    public List<SearchGet> searchGame(String name) {
        return gamesDao.fuzzyQueryGame(name);
    }

    @Override
    public List<GameSimpleGet> findGameSimplesByTag(String tag) {
        int tid = tagsDao.queryId(tag);
        List<GameSimpleGet> list = gamesDao.queryGameInfosWithTidOrderByHot(tid);
        for (GameSimpleGet gameSimpleGet : list) {
            gameSimpleGet.setFormat(DateKit.formatDateByUnixTime(gameSimpleGet.getTime(), "yyyy-MM-dd"));
            gameSimpleGet.setImgArr(imagesDao.queryEffectByGid(gameSimpleGet.getGid(), 1));
            gameSimpleGet.setTags(tagsDao.queryAllTagsByGid(gameSimpleGet.getGid()));
        }

        return list;
    }

    @Override
    public List<GameSimpleGet> findGameSimplesNewest() {
        List<GameSimpleGet> list = gamesDao.queryGameSimplesNewest();
        for (GameSimpleGet gameSimpleGet : list) {
            gameSimpleGet.setFormat(DateKit.formatDateByUnixTime(gameSimpleGet.getTime(), "yyyy-MM-dd"));
            gameSimpleGet.setImgArr(imagesDao.queryEffectByGid(gameSimpleGet.getGid(), 1));
            gameSimpleGet.setTags(tagsDao.queryAllTagsByGid(gameSimpleGet.getGid()));
        }
        return list;
    }

    @Override
    public List<GameMonthTop> findGameMonthTop() {
        return gamesDao.queryGameInfoWithMonth();
    }

    @Override
    public List<GameNavGet> findGameNav() {
        return gamesDao.queryGameNav();
    }

    @Override
    public List<GameRecommendGet> findGameRecommend() {
        List<GameRecommendGet> list = gamesDao.queryGameInfoWithRecommend();
        for (GameRecommendGet get : list) {
            get.setImgArr(imagesDao.queryEffectByGid(get.getGid(), 1));
        }
        return list;
    }

    @Override
    public List<GameSimilarGet> findGameSimilar(String tag) {
        return gamesDao.queryGameSimilar(tag);
    }

    @Override
    public GameUserRecommendGet findUserRecommend() {
        return gamesDao.queryUserRecommend();
    }

    @Override
    public List<GameMonthTop> findGameMonthNewTop(int nowTime) {
        return gamesDao.queryGameMonthTop(nowTime);
    }

    @Override
    public List<GameWeekTopGet> findGameWeekTop() {
        return gamesDao.queryGameWeekTop();
    }

    @Override
    public List<GameDiscountGet> findGameDiscount() {


        return gamesDao.queryGameDiscount();
    }
}
