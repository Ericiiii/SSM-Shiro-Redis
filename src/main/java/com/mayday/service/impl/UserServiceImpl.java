package com.mayday.service.impl;

import com.mayday.dao.UserDao;
import com.mayday.model.UserModel;
import com.mayday.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public UserModel login(UserModel userModel) {
        return userDao.login(userModel);
    }
    //更新用户信息
    public void updateUserByPrimaryKey(UserModel userModel) {
         userDao.updateUserByPrimaryKey(userModel);
    }

     //用戶註冊
    public void insertUser(UserModel userModel) {
        userDao.register(userModel);
    }
}
