package com.a7z.sevenzgame.domain;

import com.a7z.sevenzgame.entity.Json;
import com.a7z.sevenzgame.entity.po.Game;
import com.a7z.sevenzgame.entity.pojo.Cart;
import com.a7z.sevenzgame.entity.vo.get.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lq
 * @create 2020/3/13-09:29
 */
@Repository
public interface GamesDao {


    /**
     * 查询游戏的bg
     *
     * @param gid 游戏主键
     * @return bg
     */
    @Select({
            "select bg from games where gid =#{gid}"
    })
    String queryBg(int gid);

    @Select({
            "select configuration from games where gid =#{gid}"
    })
    String queryConfigure(int gid);

    /**
     * 查询购物车信息
     *
     * @param gid 主键
     * @return cart
     */
    @Select({
            "SELECT gid,company ,name,cover,cost,price\n" +
                    "FROM games WHERE gid =#{gid}"
    })
    @Results(id = "cart", value = {
            @Result(id = true, property = "gid", column = "gid"),
            @Result(property = "cid", column = "company"),
            @Result(property = "game", column = "name"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "cost", column = "cost"),
            @Result(property = "price", column = "price")
    })
    Cart queryCart(int gid);

    /**
     * 搜索所有的公司信息
     *
     * @return List<Json>
     */
    @Select({
            "SELECT c.`name` FROM games g,company c WHERE g.company = c.cid"
    })
    @Results(id = "c", value = {
            @Result(id = true, property = "id", column = "cid"),
            @Result(property = "text", column = "name")
    })
    List<Json> findCompany();

    /**
     * 查询公司旗下的游戏数量
     *
     * @param cid 公司主键
     * @return 数量
     */
    @Select({
            "select count(*) FROM games WHERE company=#{cid}"
    })
    int queryGameNum(int cid);

    @Select({
            "select gid,name,cover,describes,videourl,price,videoBg,time from games where company=#{cid}"
    })
    List<GameComGet> queryGameComList(int cid);

    /**
     * 更改games的url信息
     *
     * @param gid 主键
     * @param url url
     */
    @Update({
            "update games set url =#{url} where gid=#{gid}"
    })
    void updateGamesUrl(int gid, String url);

    /**
     * 向games表中插入一条游戏数据
     *
     * @param game game
     */
    @Insert({
            "insert into games " +
                    "(gid,name,time,company,price,discount,describes,cover,videourl,videoBg,bg,detail,configuration,language ) " +
                    "VALUES" +
                    "(#{gid},#{name},#{time},#{company},#{price},#{discount},#{describes},#{cover},#{videourl},#{videoBg},#{bg},#{detail},#{configuration},#{language});"
    })
    void addOne(Game game);


    /**
     * 根据gid查询游戏名
     *
     * @param gid 主键
     * @return 游戏名
     */
    @Select({
            "select name from games where gid =#{gid}"
    })
    String queryGameName(int gid);

    /**
     * 根据gid查询游戏url
     *
     * @param gid 主键
     * @return url
     */
    @Select({
            "select url from games where gid =#{gid}"
    })
    String queryGameUrl(int gid);

    /**
     * 根据gid查询游戏company
     *
     * @param gid 主键
     * @return company
     */
    @Select({
            "select company from games where gid =#{gid}"
    })
    int queryGameCompany(int gid);


    /**
     * 查询具有折扣优惠的game信息
     *
     * @return List<GameDiscountGet>
     */
    @Select({
            "select gid,name,cover,discount,cost,price from games where discount !='' order by rand() limit 3"
    })
    List<GameDiscountGet> queryGameDiscount();

    /**
     * 查询一周热销游戏信息
     *
     * @return List<GameWeekTopGet>
     */
    @Select({
            "select gid,cover,name,price from games order by hot limit 7 "
    })
    List<GameWeekTopGet> queryGameWeekTop();

    /**
     * 查询最近30天的热门游戏信息
     *
     * @param nowTime 现在的时间
     * @return List<GameMonthTop>
     */
    @Select({
            "select gid,name,price,cover from games WHERE #{nowTime}-time<2592000 ORDER BY hot LIMIT 4"
    })
    List<GameMonthTop> queryGameMonthTop(int nowTime);

    /**
     * 查询随机一条用户推荐游戏基本信息
     *
     * @return GameUserRecommendGet
     */
    @Select({
            "select gid ,cover,videourl from games order by rand() limit 1"
    })
    GameUserRecommendGet queryUserRecommend();

    /**
     * 从games表中获取一条游戏数据
     *
     * @param gid 游戏主键
     * @return game
     */
    @Select({
            "select * from games where gid=#{gid}"
    })
    @Results(id = "game", value = {
            @Result(id = true, property = "gid", column = "gid"),
            @Result(property = "name", column = "name"),
            @Result(property = "time", column = "time"),
            @Result(property = "company", column = "company"),
            @Result(property = "cost", column = "cost"),
            @Result(property = "price", column = "price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "describes", column = "describes"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "videourl", column = "videourl"),
            @Result(property = "videoBg", column = "videoBg"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "state", column = "state"),
            @Result(property = "bg", column = "bg"),
            @Result(property = "detail", column = "detail"),
            @Result(property = "configuration", column = "configuration"),
            @Result(property = "language", column = "language"),
            @Result(property = "hot", column = "hot"),
    })
    Game findOne(int gid);

    /**
     * 查询列表中的game简略显示信息
     *
     * @param tid 标签主键
     * @return List<GameSimpleGet>
     */
    @Select({
            "SELECT gid,name,cover,time,cost,price,discount,grade,hot \n" +
                    "FROM games g ,(SELECT gid as \"id\" FROM game_tag WHERE tid=#{tid} ) b \n" +
                    "WHERE  b.id=g.gid ORDER BY hot DESC limit 10"
    })
    @Results(id = "gameInfo", value = {
            @Result(id = true, property = "gid", column = "gid"),
            @Result(property = "name", column = "name"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "time", column = "time"),
            @Result(property = "cost", column = "cost"),
            @Result(property = "price", column = "price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "hot", column = "hot"),
    })
    List<GameSimpleGet> queryGameInfosWithTidOrderByHot(int tid);

    /**
     * 查询最新发布的10条game简略显示信息
     *
     * @return List<GameSimpleGet>
     */
    @Select({
            "select gid,name,cover,time,cost,price,discount,grade,hot  from games order by time desc limit 10"
    })
    List<GameSimpleGet> queryGameSimplesNewest();

    /**
     * 查询相似推荐
     *
     * @return List<GameSimilarGet>
     */
    @Select({
            "select gid,cover,name,cost,price,discount from games g,(SELECT a FROM (SELECT gid as a from game_tag " +
                    "WHERE tid =(SELECT tid from tag WHERE tname =#{tag})) num ORDER BY RAND() LIMIT 3) bb WHERE g.gid=bb.a"
    })
    List<GameSimilarGet> queryGameSimilar(String tag);

    /**
     * 搜索10条index界面推荐游戏的10条基本信息
     *
     * @return List<GameRecommendGet>
     */
    @Select({
            "select gid,describes,cover,name,company,cost,price,discount from games order by rand() limit 10"
    })
    List<GameRecommendGet> queryGameInfoWithRecommend();

    /**
     * 根据月度热度值进行排名
     *
     * @return gamemonthtop
     */
    @Select({
            "select gid,name,price,cover from games order by hot desc limit 4"
    })
    List<GameMonthTop> queryGameInfoWithMonth();

    /**
     * 更改热度值
     *
     * @param gid 游戏主键
     * @param num 热度值
     */
    @Update({
            "update games set hot=#{num} where gid=#{gid}"
    })
    void changeHot(int gid, int num);

    @Select({
            "select gid,name,cover from games order by hot desc limit 15"
    })
    List<GameNavGet> queryGameNav();

    /**
     * 查询热度值
     *
     * @param gid 游戏主键
     * @return 热度值
     */
    @Select({
            "select hot from games where gid=#{gid}"
    })
    int queryHot(int gid);

    /**
     * 根据游戏名字查找游戏gid
     *
     * @return 游戏id、
     */
    @Select({
            "SELECT gid from games where name=#{name};"
    })
    String getGidByName(String name);


    /**
     * 寻找最后一个已用的id
     *
     * @return id值
     */
    @Select({
            "select gid from games ORDER BY gid DESC limit 1"
    })
    int getLastId();


    /**
     * 根据发布时间查询GameComGet
     *
     * @param cid   公司主键
     * @param start 开始索引
     * @param limit 限制条数
     * @return List<GameComGet>
     */
    @Select({
            "SELECT gid,name,cover,describes,videourl,videoBg,time from games " +
                    "where company = #{cid} ORDER BY time DESC LIMIT #{start}, #{limit} ;"
    })
    List<GameComGet> queryGameComListTimeSort(int cid, int start, int limit);


    /**
     * 根据游戏热度查询GameComGet
     *
     * @param cid   公司主键
     * @param start 开始索引
     * @param limit 限制条数
     * @return List<GameComGet>
     */
    @Select({
            "SELECT gid,name,cover,describes,videourl,videoBg,time from games " +
                    "where company = #{cid} ORDER BY hot DESC LIMIT #{start}, #{limit} ;"
    })
    List<GameComGet> queryGameComListHotSort(int cid, int start, int limit);

    /**
     * 模糊查询游戏
     *
     * @param value 游戏名
     * @return List<SearchGet>
     */
    @Select({
            "select gid,name,cover,price from games where name like '%${value}%'"
    })
    @Results(id = "SearchGame", value = {
            @Result(id = true, property = "id", column = "gid"),
            @Result(property = "name", column = "name"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "price", column = "price")
    })
    List<SearchGet> fuzzyQueryGame(String value);

}
