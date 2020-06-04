package com.a7z.sevenzgame.service.impl;

import com.a7z.sevenzgame.domain.ImagesDao;
import com.a7z.sevenzgame.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @create 2020/3/14-16:07
 */
@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    ImagesDao imagesDao;

    @Override
    public void addImage(int gid,int distinguish ,String name) {
        imagesDao.addOne(gid,distinguish,name);
    }

    @Override
    public void changeStateTo0(String name) {
        imagesDao.changeState(name);
    }
}
