package com.a7z.sevenzgame.service.impl;

import com.a7z.sevenzgame.domain.ImageDao;
import com.a7z.sevenzgame.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @create 2020/3/14-16:07
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDao imageDao;

    @Override
    public void addImage(String gid, String name) {
        imageDao.addOne(gid,name);
    }

    @Override
    public void changeStateTo0(String name) {
        imageDao.changeState(name);
    }
}
