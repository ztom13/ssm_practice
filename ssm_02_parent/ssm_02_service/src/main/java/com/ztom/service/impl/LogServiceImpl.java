package com.ztom.service.impl;

import com.ztom.dao.LogDao;
import com.ztom.domain.SysLog;
import com.ztom.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:ztom
 * date:2018/11/5 11:13
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public void save(SysLog log) {
        logDao.save(log);
    }
}
