package com.itdr.service.impl;

import com.itdr.commom.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao ud=new UserDao();
    @Override
    public ResponseCode<Users> login(String username, String password) {
        //参数非空判断
        Users users = ud.selectByUserNameAndPassword(username, password);
        //返回null说明用户不存在
        if (users==null){
            return ResponseCode.toDefeated("用户不存在");
        }else {
            return ResponseCode.toSuccess(users);
        }
    }
}
