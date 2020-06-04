package com.a7z.sevenzgame.service;

import com.a7z.sevenzgame.entity.pojo.Cart;
import com.a7z.sevenzgame.entity.vo.GameCommit;
import com.a7z.sevenzgame.entity.vo.get.*;

import java.util.List;

/**
 * @author lq
 * @create 2020/3/14-21:52
 */
public interface GamesService {
    void addOne(GameCommit gameCommit);


    GameDetailGet findOne(int gid);

    void addHot(int gid, int num);

    Cart findCart(int gid);

    String findName(int gid);

    String findBg(int gid);

    String findConfiguration(int gid);

    List<SearchGet> searchGame(String name);

    List<GameSimpleGet> findGameSimplesByTag(String tag);

    List<GameSimpleGet> findGameSimplesNewest();

    List<GameMonthTop> findGameMonthTop();

    List<GameNavGet> findGameNav();

    List<GameRecommendGet> findGameRecommend();

    List<GameSimilarGet> findGameSimilar(String tag);

    GameUserRecommendGet findUserRecommend();

    List<GameMonthTop> findGameMonthNewTop(int nowTime);

    List<GameWeekTopGet> findGameWeekTop();

    List<GameDiscountGet> findGameDiscount();


}
