package com.ztom.log;

import com.ztom.domain.SysLog;
import com.ztom.service.LogService;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:ztom
 * date:2018/11/5 10:38
 */
@Controller
@Aspect
public class LogController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LogService logService;

    @Pointcut("execution(* com.ztom.controller.*.*(..))")
    public void pointcut(){}

    @Before(value = "pointcut()")
    public void after(JoinPoint joinPoint){
        SysLog log = new SysLog();

        // 访问时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(new Date());
        log.setVisitTime(dateStr);

        // 访问人的名字
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        log.setUsername(username);

        // 访问人的ip地址
        String ip = request.getRemoteAddr();
        log.setIp(ip);

        // 访问的方法
        String className = joinPoint.getTarget().getClass().getName();
        Signature methodName = joinPoint.getSignature();
        log.setMethod(className+"."+methodName);

        logService.save(log);
    }
}
