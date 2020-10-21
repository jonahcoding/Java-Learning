package com.shinrin.service.user;

import com.shinrin.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userCode, String password);
}
