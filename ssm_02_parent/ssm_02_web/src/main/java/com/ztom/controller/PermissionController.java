package com.ztom.controller;

import com.ztom.domain.Permission;
import com.ztom.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/3 11:27
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView();

        List<Permission> permissionList = permissionService.findAll();

        model.addObject("permissionList",permissionList);

        model.setViewName("permission-list");

        return model;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(Integer pid){
        ModelAndView model = new ModelAndView();

        List<Permission> permissionList = permissionService.findByPid(pid);

        model.addObject("permissionList",permissionList);

        model.setViewName("permission-add");

        return model;
    }

    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }
}
