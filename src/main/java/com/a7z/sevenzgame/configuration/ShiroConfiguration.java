package com.a7z.sevenzgame.configuration;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * 编写shiro配置类
 *
 * @author lq
 * @create 2020/3/15-23:14
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置整个项目的安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器，必须对资源进行拦截才能起作用
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        /*
            anno:开放权限，无需登录游客就可以访问
            authc：必须认证(登录)了才能访问
            user：必须拥有记住我功能才能使用
            role：拥有某个角色权限才能访问
            perms：拥有对某个资源的权限才能访问

         */
//        filterMap.put("/admin/*", "authc");//拦截的是url路径
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/admin");//拦截到未登录跳转的页面的url

        return shiroFilterFactoryBean;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联自定义的realm
        securityManager.setRealm(myRealm);
        return securityManager;


    }


    /**
     * 自定义realm
     *
     * @return
     */
    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }


}
