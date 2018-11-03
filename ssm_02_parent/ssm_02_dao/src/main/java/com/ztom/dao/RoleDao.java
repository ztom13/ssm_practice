package com.ztom.dao;

import com.ztom.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 11:05
 */
public interface RoleDao {

    /**
     * 查询全部角色
     *
     * @return
     */
    @Select("select * from sys_role")
    List<Role> findAll();

    /**
     * 保存角色
     *
     * @param role
     */
    @SelectKey(keyProperty = "id", keyColumn = "id", before = true,
            resultType = Integer.class,
            statement = "select role_seq.nextval from dual")
    @Insert("insert into sys_role values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);
}
