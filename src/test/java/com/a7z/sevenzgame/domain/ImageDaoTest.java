package com.a7z.sevenzgame.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author lq
 * @create 2020/3/14-15:18
 */
@SpringBootTest
class ImageDaoTest {
    @Autowired
    ImageDao imageDao;

    @Test
    void imageTest(){
//        imageDao.addOne("10003","test");
//        imageDao.changeState("test");
        List<String> strings = imageDao.queryImagesByGidWithState1("10000");
        for (String string : strings) {
            System.out.println(string);
        }


    }


}
