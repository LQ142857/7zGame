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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Admin登录注册操作
 * @author lq
 * @create 2020/3/16-21:17
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    AdministratorsService administratorsService;

    /**
     * 管理系统登录页面
     * @return
     */
    @RequestMapping("/admin")
    public ModelAndView shiro() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/testShiro");
        model.addObject("msg", "请登录");
        return model;
    }

    /**
     * 管理系统提交登录
     * @param id
     * @param password
     * @return
     */
    @RequestMapping("/adminLogin")
    public ModelAndView shiroLogin(String id, String password) {
        ModelAndView model = new ModelAndView();
        model.setViewName("/testShiro");
        Subject subject = SecurityUtils.getSubject();
        SimpleHash md5 = new SimpleHash("MD5", password, id,3);
        UsernamePasswordToken token = new UsernamePasswordToken(id, md5.toString());

        try {
            subject.login(token);
            System.out.println("登录成功");
            model.setViewName("/show/index");
            return model;
        } catch (UnknownAccountException e) {//用户名不存在
            System.out.println("用户不存在");
            model.addObject("msg", "用户名不存在");
            return model;
        } catch (IncorrectCredentialsException e) {//密码错误
            System.out.println("密码错误");
            model.addObject("msg", "密码错误");
            return model;
        }
    }

    /**
     * 管理系统提交注册
     * @param id
     * @param password
     * @param name
     * @return
     */
    @RequestMapping("/adminRegistered")
    public ModelAndView shiroRegistered(String id, String password, String name) {
        ModelAndView model = new ModelAndView();
        SimpleHash md5 = new SimpleHash("MD5", password, id,3);
        String encrypt = md5.toString();
        Administrators administrators = new Administrators();
        administrators.setAdminId(id);
        administrators.setName(name);
        administrators.setPassword(encrypt);
        administratorsService.addOne(administrators);
        model.addObject("msg", "注册成功！");
        model.setViewName("/testShiro");
        return model;
    }
    @Scheduled(cron="0/5 * *  * * ? ")
    public void test(){
        System.out.println("zhixingle ");

    }




}
