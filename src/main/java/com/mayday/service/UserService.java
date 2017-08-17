package com.mayday.service;

import com.mayday.model.UserModel;

public interface UserService {

    UserModel login(UserModel userModel);

    //更新用户信息
    void updateUserByPrimaryKey(UserModel userModel);
}
