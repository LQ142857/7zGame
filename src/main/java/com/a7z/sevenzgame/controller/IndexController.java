package com.a7z.sevenzgame.controller;

import com.a7z.sevenzgame.entity.po.Administrators;
import com.a7z.sevenzgame.service.AdministratorsService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Admin登录注册操作
 * @author lq
 * @create 2020/3/16-21:17
 */
@Controller
@RequestMapping("/test")
public class IndexController {




    /**
     * 管理系统登录页面
     * @return
     */
    @RequestMapping("")
    public ModelAndView shiro() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/testShiro");
        model.addObject("msg", "请登录");
        return model;
    }




}
