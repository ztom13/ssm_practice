package com.ztom.service;

import com.ztom.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/2 11:26
 */
public interface UserService extends UserDetailsService {
    /**
     * 查询全部的用户
     * @return
     */
    List<SysUser> findAll();

    /**
     * 添加用户
     * @param sysUser
     */
    void save(SysUser sysUser);

    /**
     * 判断用户名是否已存在
     * @param username
     * @return
     */
    Boolean isExist(String username);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    SysUser findById(Integer id);

    /**
     * 给用户添加/删除角色
     * @param userId
     * @param ids
     */
    void addRole(Integer userId, Integer[] ids);
}
