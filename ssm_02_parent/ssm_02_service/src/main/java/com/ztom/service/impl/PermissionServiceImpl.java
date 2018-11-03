package com.ztom.service.impl;

import com.ztom.dao.PermissionDao;
import com.ztom.domain.Permission;
import com.ztom.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 11:31
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findByPid(Integer pid) {
        return permissionDao.findByPid(pid);
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
