package com.a7z.sevenzgame.controller.admin;


import com.a7z.sevenzgame.entity.po.Administrators;
import com.a7z.sevenzgame.entity.vo.ResultAdmin;
import com.a7z.sevenzgame.service.AdministratorsService;
import com.a7z.sevenzgame.utils.UUID;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lq
 * @create 2020/3/13-09:27
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdministratorsService administratorsService;


    /**
     * 管理系统提交登录
     *
     * @param id
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResultAdmin shiroLogin(String id, String password) {
        ResultAdmin json = new ResultAdmin();
        Subject subject = SecurityUtils.getSubject();
        SimpleHash md5 = new SimpleHash("MD5", password, id, 3);
        UsernamePasswordToken token = new UsernamePasswordToken(id, md5.toString());
        try {
            subject.login(token);
            json.setCode(200);
            return json;
        } catch (UnknownAccountException e) {//用户名不存在
            json.setMsg("用户名不存在");
            json.setCode(404);
            return json;
        } catch (IncorrectCredentialsException e) {//密码错误
            json.setMsg("密码错误");
            json.setCode(403);
            return json;
        }
    }

    /**
     * 管理系统提交注册
     *
     * @param id
     * @param password
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResultAdmin shiroRegistered(String id, String password, String name) {
        ResultAdmin json = new ResultAdmin();
        String s = administratorsService.queryId(id);
        if (!s.equals(id)) {
            SimpleHash md5 = new SimpleHash("MD5", password, id, 3);
            String encrypt = md5.toString();
            Administrators administrators = new Administrators();
            administrators.setAdminId(id);
            administrators.setName(name);
            administrators.setPassword(encrypt);
            administratorsService.addOne(administrators);
            System.out.println("cahru");
            json.setCode(200);
            json.setMsg("注册成功");
            return json;
        }
        json.setCode(404);
        json.setMsg("账号已存在");
        System.out.println("yicunzai ");
        return json;

    }


    @RequestMapping("/submitGame")
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView();
        model.addObject("id", UUID.UU32());
        model.setViewName("/Admin/submitGame");
        return model;
    }


}
