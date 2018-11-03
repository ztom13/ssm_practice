package com.ztom.service;

import com.ztom.domain.Role;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 11:03
 */
public interface RoleService {
    /**
     * 查询全部角色
     * @return
     */
    List<Role> findAll();

    /**
     * 保存角色
     * @param role
     */
    void save(Role role);
}
