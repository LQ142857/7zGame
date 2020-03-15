package com.a7z.sevenzgame.domain;

import com.a7z.sevenzgame.entity.po.Games;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author lq
 * @create 2020/3/13-09:29
 */
@Repository
public interface GamesDao {

    /**
     * 向games表中插入一条游戏数据
     *
     * @param
     */

    @Insert({
            "insert into games " +
                    "(name,company,price,discount,pubdate,cover,videourl,describes ) " +
                    "VALUES" +
                    "(#{name},#{company},#{price},#{discount},#{pubdate},#{cover},#{videourl},#{describes});"
    })
    void addOne(Games games);


    /**
     * 根据游戏名字查找游戏gid
     * @return
     */
    @Select({
            "SELECT gid from games where name=#{name};"
    })
    String getGidByName(String name);


}
