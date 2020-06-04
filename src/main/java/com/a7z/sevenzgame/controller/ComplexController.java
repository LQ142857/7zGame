package com.a7z.sevenzgame.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录注册操作
 *
 * @author lq
 * @create 2020/3/16-21:17
 */
@Controller
@RequestMapping("")
public class ComplexController {



    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        model.addObject("identity","请登录" );
        model.addObject("msg", "请登录");
        return model;
    }

    @RequestMapping("/noRight")
    public ModelAndView noRight() {
        ModelAndView model = new ModelAndView();
        model.setViewName("401");
        return model;
    }







}
