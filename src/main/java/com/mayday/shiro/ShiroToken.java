package com.mayday.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

public class ShiroToken extends UsernamePasswordToken implements Serializable {

    private static final long serialVersionUID = -6451794657814516274L;

    //登录密码[字符串类型] 因为父类是char[]
    private String password ;

    public ShiroToken(String userName, String password) {
        super(userName,password);
        this.password = password ;
    }


    public String getPsd() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
