package com.mayday.dao;

import com.mayday.model.UserModel;

import java.util.Map;

public interface UserDao {

    //登录
    public UserModel login(UserModel userModel);

    //更新用户信息
    public void updateUserByPrimaryKey(UserModel userModel);

}
