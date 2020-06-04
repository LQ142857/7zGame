package com.a7z.sevenzgame;

import com.a7z.sevenzgame.domain.AdministratorsDao;
import com.a7z.sevenzgame.entity.vo.get.CompilationGameGet;
import com.a7z.sevenzgame.service.CompilationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SevenzgameApplicationTests {

    @Autowired
    AdministratorsDao administratorsDao;
    @Autowired
    CompilationService compilationService;

    @Test
    void contextLoads() {
//        int cid = compilationService.randId();
//
//        System.out.println(compilationService.findGameList(cid));

    }


}
