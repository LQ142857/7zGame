package com.a7z.sevenzgame.configuration;

import com.a7z.sevenzgame.service.AdministratorsService;
import com.a7z.sevenzgame.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 编写shiro中自定义的realm
 *
 * @author lq
 * @create 2020/3/15-23:16
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();

        String principal = subject.getPrincipal().toString();

        System.out.println("principal=========="+principal);
//        List<String> perms = userService.queryPermById(principal);
//        System.out.println(perms);
//        for (String perm : perms) {
//            info.addStringPermission(perm);
//        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Integer id = userService.findId(token.getUsername());
        if (id == null) {//UnknownAccountException用户不存在情况
            return null;
        }
        String account = token.getUsername();
        String password = userService.findPassword(account);//正真的密码
        //参数一用户名或者对象也可以，参数二从数据库中拿出的密码用于后面的对比，第三个参数加盐ByteSource.Util.bytes(username) 第四个使用的realm的类名
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(id, password, "");
        return authenticationInfo;
    }
}
