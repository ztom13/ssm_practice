package com.ztom.controller;

import com.ztom.domain.Role;
import com.ztom.domain.SysUser;
import com.ztom.service.RoleService;
import com.ztom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/2 20:09
 */
@Controller
@RequestMapping("/user")
@Secured({"ROLE_ADMIN"})
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 查询全部用户
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView();

        List<SysUser> userList = userService.findAll();

        model.addObject("userList",userList);

        model.setViewName("user-list");

        return model;
    }

    /**
     * 保存新用户
     * @param sysUser
     * @return
     */
    @RequestMapping("/save")
    public String save(SysUser sysUser){
        userService.save(sysUser);
        return "redirect:/user/findAll";
    }

    /**
     * 判断新用户名是否已存在
     * @param username
     * @return
     */
    @RequestMapping("/isExist")
    @ResponseBody
    public String isExist(String username){
        Boolean b = userService.isExist(username);
        return b+"";
    }

    /**
     * 查看用户的角色和权限详情
     * @param id
     * @return
     */
    @RequestMapping("/details")
    public ModelAndView details(Integer id){
        ModelAndView model = new ModelAndView();

        SysUser user = userService.findById(id);

        model.addObject("user",user);

        model.setViewName("user-show");

        return model;
    }

    /**
     * 给用户添加/删除角色的数据回显
     * @param id
     * @return
     */
    @RequestMapping("/addRoleUI")
    public ModelAndView addRoleUI(Integer id){
        ModelAndView model = new ModelAndView();

        // 查询全部角色信息,回显到添加页面
        List<Role> roleList = roleService.findAll();

        // 根据id查询用户信息
        SysUser user = userService.findById(id);
        // 查询用户已拥有的角色
        List<Role> roles = user.getRoleList();
        // 拼接角色id的字符串,用于回显用户已拥有的角色
        StringBuilder sb = new StringBuilder();
        for (Role role : roles) {
            sb.append(",").append(role.getId()).append(",");
        }

        model.addObject("roleList",roleList);
        model.addObject("userId",user.getId());
        model.addObject("roles",sb.toString());

        model.setViewName("user-role-add");

        return model;
    }

    @RequestMapping("/addRole")
    public String addRole(Integer userId,Integer[] ids){
        userService.addRole(userId,ids);
        return "redirect:/user/findAll";
    }
}
