package com.ztom.service.impl;

import com.ztom.dao.RoleDao;
import com.ztom.domain.Role;
import com.ztom.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 11:04
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer id) {
        return roleDao.findById(id);
    }

    @Override
    public void addPermission(Integer roleId, Integer[] ids) {
        roleDao.deletePermission(roleId);
        if(ids!=null&&ids.length>0){
            for (Integer id : ids) {
                roleDao.addPermission(roleId,id);
            }
        }
    }
}
