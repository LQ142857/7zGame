package com.a7z.sevenzgame.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作Image数据库表
 * 添加一条Image数据
 * 修改已有图片的状态为不显示
 * 查询GId下的所有Image
 * 查询GId下的所有显示状态Image
 *
 * @author lq
 * @create 2020/3/14-14:47
 */
@Repository
public interface ImageDao {

    /**
     * 添加一条Image数据
     */
    @Insert({
            "INSERT INTO images(gid,srcname,state) VALUES(#{gid},#{name},\"1\");"
    })
    void addOne(String gid,String name);

    /**
     * 修改已有图片的状态为不显示
     */
    @Update({
            "UPDATE images SET state=\"0\" WHERE srcname =#{name};"
    })
    void changeState(String name);

    /**
     * 查询GId下的所有Image
     *
     * @param gid
     * @return
     */
    @Select({
            "SELECT srcname FROM images WHERE gid = #{gid} ;"
    })
    List<String> queryImagesByGid(String gid);

    /**
     * 查询GId下的所有显示状态Image
     * @param gid
     * @return
     */
    @Select({
            "SELECT srcname FROM images WHERE gid = #{gid} AND state =\"1\" ;"
    })
    List<String> queryImagesByGidWithState1(String gid);

}
