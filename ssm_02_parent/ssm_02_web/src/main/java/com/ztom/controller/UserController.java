package com.ztom.controller;

import com.ztom.domain.SysUser;
import com.ztom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView();

        List<SysUser> userList = userService.findAll();

        model.addObject("userList",userList);

        model.setViewName("user-list");

        return model;
    }

    @RequestMapping("/save")
    public String save(SysUser sysUser){
        userService.save(sysUser);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/isExist")
    @ResponseBody
    public String isExist(String username){
        Boolean b = userService.isExist(username);
        return b+"";
    }
}
