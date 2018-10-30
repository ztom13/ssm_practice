package com.ztom.controller;

import com.ztom.domain.Hero;
import com.ztom.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/28 13:43
 */
@Controller
@RequestMapping("/hero")
public class HeroController {
    @Autowired
    HeroService heroService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView();
        List<Hero> heroes = heroService.findAll();
        model.addObject("heroes",heroes);
        model.setViewName("list");
        return model;
    }
}
