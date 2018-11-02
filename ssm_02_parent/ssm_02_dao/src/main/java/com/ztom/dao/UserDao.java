package com.ztom.dao;

import com.ztom.domain.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * author:ztom
 * date:2018/11/2 11:31
 */
public interface UserDao {

    @Select("select * from sys_user where username=#{username}")
    SysUser findByUsername(String username);
}
