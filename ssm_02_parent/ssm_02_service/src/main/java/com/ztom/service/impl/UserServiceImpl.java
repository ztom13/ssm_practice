package com.ztom.service.impl;

import com.ztom.dao.UserDao;
import com.ztom.domain.SysUser;
import com.ztom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userDao.findByUsername(username);
        if(sysUser != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            authorities.add(grantedAuthority);
            UserDetails userDetails = new User(sysUser.getUsername(), "{noop}"+sysUser.getPassword(),authorities);
            return userDetails;
        }
        return null;
    }
}
