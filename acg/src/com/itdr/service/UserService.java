package com.itdr.service;

import com.itdr.commom.ResponseCode;
import com.itdr.pojo.Users;

public interface UserService {
    ResponseCode<Users> login(String username,String password);
}
