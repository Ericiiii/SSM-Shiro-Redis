package com.mayday.shiro;

import com.mayday.model.UserModel;
import com.mayday.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;

/**
 * Token管理類
 */
public class TokenManage {

    //登錄
    public static void login(UserModel userModel, Boolean rememberMe){

        UsernamePasswordToken token = new UsernamePasswordToken(userModel.getUserName(), MD5Utils.encode(userModel.getPassword()));
        //記住我
         token.setRememberMe(rememberMe);
        //得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager =new DefaultSecurityManager(new UserRealm());

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        //斷言用戶已經登錄
        Assert.assertEquals(true, subject.isAuthenticated());

    }


    //退出登錄

    public static void logout(){
      SecurityUtils.getSubject().logout();
    }

    //判斷是否登錄

    public static Boolean isLogin(){

        return null != SecurityUtils.getSubject().getPrincipal();
    }





}
