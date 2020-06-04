package com.a7z.sevenzgame.domain;

import com.a7z.sevenzgame.entity.po.Administrator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lq
 * @create 2020/3/16-11:17
 */
@Repository
public interface AdministratorsDao {


    @Insert({
            "insert INTO administrators (admin_id,name,`password`) VALUES (#{adminId},#{name},#{password}) "
    })
    void addOne(Administrator administrator);

    @Select({
            "SELECT * FROM administrators WHERE admin_id =#{username} AND `password`=#{password};"
    })
    @Results({
            @Result(id = true, property = "adminId", column = "adminId"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name")

    })
    Administrator findOne(String username, String password);

    @Select({
            "SELECT admin_id FROM administrators WHERE admin_id =#{id} "
    })
    String queryId(String id);

    @Select({
            "SELECT password FROM administrators WHERE admin_id =#{id} "
    })
    String queryPasswordById(String id);


    @Select({
            "SELECT name\n" +
                    "from administrators_perm,perm\n" +
                    "WHERE perm.perm_id=administrators_perm.perm_id\n" +
                    "and\n" +
                    "administrators_perm.admin_id=#{id}"
    })
    List<String> queryPermById(String id);

}
