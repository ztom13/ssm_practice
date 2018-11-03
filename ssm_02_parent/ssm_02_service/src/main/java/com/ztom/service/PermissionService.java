package com.ztom.service;

import com.ztom.domain.Permission;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 11:31
 */
public interface PermissionService {
    /**
     * 查询全部权限
     * @return
     */
    List<Permission> findAll();

    /**
     * 根据pid查询权限
     * @return
     */
    List<Permission> findByPid(Integer pid);

    /**
     * 保存权限
     * @param permission
     */
    void save(Permission permission);

}
