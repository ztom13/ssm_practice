package com.ztom.domain;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 10:59
 */
public class Role {
    private Integer id;

    private String roleName;

    private String roleDesc;

    // 一个角色拥有哪些权限
    private List<Permission> permissionList;

    // 一个角色被哪些用户所拥有
    private List<SysUser> userList;

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
