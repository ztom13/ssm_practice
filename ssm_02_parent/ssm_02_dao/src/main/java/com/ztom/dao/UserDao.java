package com.ztom.dao;

import com.ztom.domain.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/2 11:31
 */
public interface UserDao {

    /**
     * 根据用户名查询用户数据
     *
     * @param username
     * @return
     */
    @Select("select * from sys_user where username=#{username}")
    SysUser findByUsername(String username);

    /**
     * 根据用户名查询开启状态的用户
     *
     * @param username
     * @return
     */
    @Select("select * from sys_user where username=#{username} and status=1")
    SysUser findByUsernameWithStatus(String username);

    /**
     * 查询全部用户
     *
     * @return
     */
    @Select("select * from sys_user")
    List<SysUser> findAll();

    /**
     * 保存用户
     *
     * @param sysUser
     */
    @SelectKey(keyProperty = "id", keyColumn = "id", before = true,
            resultType = Long.class,
            statement = "select user_seq.nextval from dual")
    @Insert("insert into sys_user values(#{id},#{username}," +
            "#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser sysUser);
}
