package com.a7z.sevenzgame.service;

import org.springframework.stereotype.Service;

/**
 * Image的Service层
 *
 * @author lq
 * @create 2020/3/14-15:54
 */

public interface ImageService {
    public void addImage(String gid, String name);
    public void changeStateTo0(String name);


}
