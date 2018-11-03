package com.ztom.dao;

import com.ztom.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 11:32
 */
public interface PermissionDao {
    /**
     * 查询全部权限
     *
     * @return
     */
    @Select("select * from sys_permission")
    List<Permission> findAll();

    /**
     * 根据pid查询权限
     *
     * @param pid
     * @return
     */
    @Select("select * from sys_permission where pid=#{pid}")
    List<Permission> findByPid(Integer pid);

    /**
     * 保存权限
     *
     * @param permission
     */
    @SelectKey(keyProperty = "id", keyColumn = "id", before = true,
            resultType = Integer.class,
            statement = "select permission_seq.nextval from dual")
    @Insert("insert into sys_permission values(#{id},#{permissionName},#{url},#{pid})")
    void save(Permission permission);
}
