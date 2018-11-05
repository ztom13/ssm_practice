package com.ztom.controller;

import com.ztom.domain.Permission;
import com.ztom.domain.Role;
import com.ztom.service.PermissionService;
import com.ztom.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 11:01
 */
@Controller
@RequestMapping("/role")
@Secured({"ROLE_ADMIN"})
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询全部角色
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView();

        List<Role> roleList = roleService.findAll();

        model.addObject("roleList",roleList);

        model.setViewName("role-list");

        return model;
    }

    /**
     * 保存新角色
     * @param role
     * @return
     */
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/findAll";
    }

    /**
     * 给角色添加/删除权限的数据回显
     * @param id
     * @return
     */
    @RequestMapping("/addPermissionUI")
    public ModelAndView addPermissionUI(Integer id){
        ModelAndView model = new ModelAndView();

        // 查询全部权限
        List<Permission> permissionList = permissionService.findAll();

        // 根据id查询角色
        Role role = roleService.findById(id);
        // 查询该角色已拥有的权限
        List<Permission> permissions = role.getPermissionList();
        // 拼接权限id的字符串,用于回显
        StringBuilder sb = new StringBuilder();
        for (Permission permission : permissions) {
            sb.append(",").append(permission.getId()).append(",");
        }

        model.addObject("permissionList",permissionList);
        model.addObject("roleId",role.getId());
        model.addObject("permissions",sb.toString());

        model.setViewName("role-permission-add");

        return model;
    }

    /**
     * 给角色添加/删除权限
     * @param roleId
     * @param ids
     * @return
     */
    @RequestMapping("/addPermission")
    public String addPermission(Integer roleId,Integer[] ids){
        roleService.addPermission(roleId,ids);
        return "redirect:/role/findAll";
    }
}
