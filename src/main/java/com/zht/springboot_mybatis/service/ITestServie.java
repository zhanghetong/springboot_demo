package com.zht.springboot_mybatis.service;

import com.zht.springboot_mybatis.entity.User;

import java.util.List;

public interface ITestServie {

    void createUserInfo(int id, String name);
    void deleteUserInfo(int id);
    void updateUserInfo(int id, String name);
    User getUserInfo(int id);
    List<User> getUserAll();


    User getUserInfo2(int id);
}
