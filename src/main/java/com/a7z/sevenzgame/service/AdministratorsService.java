package com.a7z.sevenzgame.service;

import com.a7z.sevenzgame.entity.po.Administrators;

/**
 * @author lq
 * @create 2020/3/16-12:19
 */
public interface AdministratorsService {

    void addOne(Administrators administrators);

    Administrators findOne(String username, String password);

    String queryId(String id);

    String queryPasswordById(String id);


}
