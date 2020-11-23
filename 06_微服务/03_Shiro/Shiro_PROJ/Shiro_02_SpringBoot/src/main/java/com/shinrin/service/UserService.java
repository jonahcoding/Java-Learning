package com.shinrin.service;

import com.shinrin.pojo.User;

public interface UserService {
    public User queryUserByName(String name);
}
