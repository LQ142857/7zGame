package com.a7z.sevenzgame.service.impl;

import com.a7z.sevenzgame.domain.AdministratorsDao;
import com.a7z.sevenzgame.entity.po.Administrator;
import com.a7z.sevenzgame.service.AdministratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lq
 * @create 2020/3/16-12:19
 */
@Service
public class AdministratorsServiceImpl implements AdministratorsService {

    @Autowired
    AdministratorsDao administratorsDao;

    @Override
    public void addOne(Administrator administrator) {
        administratorsDao.addOne(administrator);

    }

    @Override
    public Administrator findOne(String username, String password) {
        return administratorsDao.findOne(username, password);
    }

    @Override
    public String queryId(String id) {
        return administratorsDao.queryId(id);
    }

    @Override
    public String queryPasswordById(String id) {
        return administratorsDao.queryPasswordById(id);
    }

    @Override
    public List<String> queryPermById(String id) {
        return administratorsDao.queryPermById(id);
    }
}
