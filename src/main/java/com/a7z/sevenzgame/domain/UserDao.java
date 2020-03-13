//package com.a7z.sevenzgame.domain;
//
//import com.a7z.sevenzgame.entity.po.Test;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * @author lq
// * @create 2020/3/12-09:50
// */
//
//@Repository
//public interface UserDao {
//    @Select("select * from user")
//    @Results( id = "TestMap" ,value = {
//            @Result(id = true,property = "tid",column = "tid"),
//            @Result(property = "tname",column = "tname"),
//            @Result(property = "age",column = "age"),
//    })
//   List<Object> findAll();
//
//}
