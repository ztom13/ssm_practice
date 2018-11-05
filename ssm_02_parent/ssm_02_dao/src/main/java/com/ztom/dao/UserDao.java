package com.ztom.dao;

import com.ztom.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
     * 根据用户名查询开启可登陆状态的用户
     *
     * @param username
     * @return
     */
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "id", property = "roleList", javaType = List.class,
                    many = @Many(select = "com.ztom.dao.RoleDao.findByUid", fetchType = FetchType.LAZY))
    })
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
            resultType = Integer.class,
            statement = "select user_seq.nextval from dual")
    @Insert("insert into sys_user values(#{id},#{username}," +
            "#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser sysUser);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleList", column = "id", javaType = List.class,
                    many = @Many(select = "com.ztom.dao.RoleDao.findByUid", fetchType = FetchType.LAZY))
    })
    @Select("select * from sys_user where id=#{id}")
    SysUser findById(Integer id);

    /**
     * 根据用户id删除其已拥有的角色
     *
     * @param userId
     */
    @Delete("delete from sys_user_role where userId=#{userId}")
    void deleteRole(Integer userId);

    /**
     * 给用户添加新的角色
     *
     * @param userId
     * @param id
     */
    @Insert("insert into sys_user_role values(#{param1},#{param2})")
    void addRole(Integer userId, Integer id);

}
