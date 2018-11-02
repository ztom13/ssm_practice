package com.ztom.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * author:ztom
 * date:2018/10/25 23:06
 */
@Controller
@RequestMapping("/store")
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String stuId, String password, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String scheme = request.getScheme();
        String name = request.getServerName();
        int port = request.getServerPort();
        if ("123".equals(password)) {
            // 登陆成功
            request.getSession().setAttribute("stuId", stuId);
            return "redirect:/books/findBookList";
        } else {
            // 登陆失败
            return "redirect:" + (scheme + "://" + name + ":" + port + contextPath + "/pages/login.jsp");
        }
    }
    /**
     * redirect: 后面跟请求路径时,针对前面加/和不加/两种情况:
     *              1)/books/findBookList: / 即为项目根路径(/ + 项目名)
     *              2)findBookList: 从当前路径下发起请求,即/store/findBookList
     *              3)也可以拼接绝对路径:
     *    return "redirect:" + (scheme + "://" + name + ":" + port + contextPath + "/pages/login.jsp");
     */
}
