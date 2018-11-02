package com.ztom.controller;

import com.ztom.domain.Order;
import com.ztom.domain.Product;
import com.ztom.service.OrderService;
import com.ztom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/31 16:40
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView();

        List<Order> orderList = orderService.findAll();

        model.addObject("orderList",orderList);

        model.setViewName("order-list");

        return model;
    }

    /**
     * 添加订单的产品数据
     * @return
     */
    @RequestMapping("/addOrderUI")
    public ModelAndView addOrderUI(){
        ModelAndView model = new ModelAndView();

        List<Product> productList = productService.findAll2();

        model.addObject("productList",productList);

        model.setViewName("order-add");

        return model;
    }

    @RequestMapping("/save")
    public String save(Order order){
        orderService.save(order);
        return "redirect:/order/findAll";
    }
}
