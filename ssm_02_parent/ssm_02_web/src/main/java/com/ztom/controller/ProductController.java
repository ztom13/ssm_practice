package com.ztom.controller;

import com.github.pagehelper.PageInfo;
import com.ztom.domain.PageBean;
import com.ztom.domain.Product;
import com.ztom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/30 21:36
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 分页助手查询全部商品
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "3") Integer pageSize
    ){
        ModelAndView model = new ModelAndView();

        PageInfo<Product> pageInfo = productService.findAll(pageNum, pageSize);

        model.addObject("pageInfo",pageInfo);

        model.setViewName("product-list");

        return model;
    }

    /**
     * 手动分页查询全部商品
     * @return
     */
    @RequestMapping("/findAll1")
    public ModelAndView findAll1(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "3") Integer pageSize
    ){
        ModelAndView model = new ModelAndView();

        PageBean<Product> pageBean = productService.findAll1(pageNum, pageSize);

        model.addObject("pageBean",pageBean);

        model.setViewName("product-list");

        return model;
    }

    /**
     * 查询全部商品
     * @return
     */
    @RequestMapping("/findAll2")
    public ModelAndView findAll2(){
        ModelAndView model = new ModelAndView();

        List<Product> productList = productService.findAll2();

        model.addObject("productList",productList);

        model.setViewName("product-list");

        return model;
    }

    /**
     * 保存一个商品
     * @param product
     * @return
     */
    @RequestMapping("/save")
    public String save(Product product){
        productService.add(product);

        return "redirect:/product/findAll";
    }

    /**
     * 修改回显数据
     * @param id
     * @return
     */
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id){
        ModelAndView model = new ModelAndView();

        Product product = productService.findById(id);

        model.addObject("product",product);

        model.setViewName("product-update");

        return model;
    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    @RequestMapping("/update")
    public String update(Product product){
        productService.update(product);

        return "redirect:/product/findAll";
    }

    /**
     * 删除单个商品
     * @param id
     * @return
     */
    @RequestMapping("/delById")
    public String delById(Integer id){
        productService.delById(id);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/delSelected")
    public String delSelected(Integer[] ids){
        productService.delSelected(ids);
        return "redirect:/product/findAll";
    }
}
