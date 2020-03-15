package com.a7z.sevenzgame.domain;

import com.a7z.sevenzgame.entity.po.GameConfigure;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author lq
 * @create 2020/3/13-09:31
 */
@Repository
public interface GameConfigureDao {


    /**
     * 向gameConfigure中添加一条数据
     */
    @Insert({
            "INSERT into gameconfigure " +
                    "(gid,system,cpu,gpu,ram,directx,net,rom)" +
                    "VALUES" +
                    "(#{gid},#{system},#{cpu},#{gpu},#{ram},#{directx},${net},${rom});"

    })
    void addOne(GameConfigure gameConfigure);



}
