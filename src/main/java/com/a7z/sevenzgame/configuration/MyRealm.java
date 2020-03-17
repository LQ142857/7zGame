package com.a7z.sevenzgame.configuration;

import com.a7z.sevenzgame.service.AdministratorsService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 编写shiro中自定义的realm
 *
 * @author lq
 * @create 2020/3/15-23:16
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    AdministratorsService administratorsService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken adminToken = (UsernamePasswordToken) authenticationToken;
        String s = administratorsService.queryId(adminToken.getUsername());
        if (s == null) {//UnknownAccountException用户不存在情况
            return null;
        }

        String username = adminToken.getUsername();
        System.out.println(adminToken.getPassword());
        String password = administratorsService.queryPasswordById(username);
        System.out.println(username+"****"+password);
        //参数一用户名或者Administrators对象也可以，参数二从数据库中拿出的密码用于后面的对比，第三个参数加盐ByteSource.Util.bytes(username) 第四个使用的realm的类名
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("", password,"");
        return authenticationInfo;
    }
}
