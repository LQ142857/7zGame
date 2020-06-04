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
public interface ImagesDao {

    /**
     * 向images中添加一条数据
     * @param id 对象主键
     * @param distinguish 1游戏2用户3评论
     * @param name 图片名称
     */
    @Insert({
            "INSERT INTO images (id,distinguish,srcname) VALUES (#{id},#{distinguish},#{name})"
    })
    void addOne(int id,int distinguish,String name);

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
     * @param gid 游戏主键
     * @return 图片名列表
     */
    @Select({
            "SELECT srcname FROM images WHERE id = #{id} and distinguish=#{distinguish};"
    })
    List<String> queryAllImagesByGid(int gid,int distinguish);

    /**
     * 查询对象id下下的所有显示状态Image
     * @param id 对象主键
     * @param distinguish   1游戏2用户3评论
     * @return 图片名列表
     */
    @Select({
            "SELECT srcname FROM images WHERE id = #{id} AND state =\"1\" and distinguish=#{distinguish} limit 4;"
    })
    List<String> queryEffectByGid(int id,int distinguish);

}
