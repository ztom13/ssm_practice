package com.ztom.service.impl;

import com.ztom.dao.UserDao;
import com.ztom.domain.Role;
import com.ztom.domain.SysUser;
import com.ztom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:ztom
 * date:2018/11/2 11:27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名从数据库中查询数据
        SysUser sysUser = userDao.findByUsernameWithStatus(username);

        if (sysUser != null) {
            // 该用户数据已存在

            // 认证对象的集合
            List<GrantedAuthority> authorities = new ArrayList<>();
            List<Role> roleList = sysUser.getRoleList();
            for (Role role : roleList) {
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(grantedAuthority);
            }

            UserDetails userDetails = new User(sysUser.getUsername(), /*"{noop}"+*/sysUser.getPassword(), authorities);
            return userDetails;
        }
        return null;
    }

    @Override
    public List<SysUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(SysUser sysUser) {

        String encodePassword = bCryptPasswordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(encodePassword);

        userDao.save(sysUser);
    }

    @Override
    public Boolean isExist(String username) {
        SysUser sysUser = userDao.findByUsername(username);
        return sysUser != null;
    }

    @Override
    public SysUser findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void addRole(Integer userId, Integer[] ids) {
        userDao.deleteRole(userId);
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                userDao.addRole(userId, id);
            }
        }
    }
}
