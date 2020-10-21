package com.smbms.service.user;

import com.smbms.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userCode, String password);
}
