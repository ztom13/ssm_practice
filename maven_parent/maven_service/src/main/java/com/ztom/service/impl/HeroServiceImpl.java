package com.ztom.service.impl;

import com.ztom.dao.HeroDao;
import com.ztom.domain.Hero;
import com.ztom.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/28 13:38
 */
@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    HeroDao heroDao;

    @Override
    public List<Hero> findAll() {
        return heroDao.findAll();
    }
}
