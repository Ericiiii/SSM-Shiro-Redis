package com.mayday.shiro;

import com.mayday.model.UserModel;
import com.mayday.service.UserService;
import com.mayday.utils.ApplicationContextUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService= (UserService) ApplicationContextUtil.getBean("userService");

    public UserRealm() {
        super();
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    //认证 ：用户登录
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {


      //  ShiroToken token = (ShiroToken) authcToken;

        String username = (String)authcToken.getPrincipal();  //得到用户名
        String password = new String((char[])authcToken.getCredentials()); //得到密码

        System.out.println("userNAME"+username+password);

        UserModel user = userService.login(new UserModel(username,password));


        if(null == user){
            throw new AccountException("帐号或密码不正确！");
            /**
             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
             */
        }else if(UserModel.status_0.equals(user.getStatus())){  //判断用户是否已经被锁定
            throw new DisabledAccountException("帐号已经禁止登录！");
        }else{
            //更新登录时间
            user.setLastLoginTime(new Date());

            userService.updateUserByPrimaryKey(user);
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(), getName());

    }
}
