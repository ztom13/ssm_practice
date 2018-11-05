package com.ztom.dao;

import com.ztom.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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

    /**
     * 根据用户id查询对应用户的角色
     * @param id
     * @return
     */
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "id",property = "permissionList",javaType = List.class,
            many = @Many(select = "com.ztom.dao.PermissionDao.findByRid",fetchType = FetchType.LAZY))
    })
    @Select("select r.* from sys_user_role ur,sys_role r " +
            "where ur.userId=#{id} and ur.roleId = r.id")
    List<Role> findByUid(Integer id);

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "id",property = "permissionList",javaType = List.class,
                    many = @Many(select = "com.ztom.dao.PermissionDao.findByRid",fetchType = FetchType.LAZY))
    })
    @Select("select * from sys_role where id=#{id}")
    Role findById(Integer id);

    @Delete("delete from sys_role_permission where roleId=#{roleId}")
    void deletePermission(Integer roleId);

    @Insert("insert into sys_role_permission values(#{param1},#{param2})")
    void addPermission(Integer roleId, Integer id);
}
