package com.zht.springboot_mybatis.service.impl;

import com.zht.springboot_mybatis.entity.User;
import com.zht.springboot_mybatis.mapper.first.TestMapper;
import com.zht.springboot_mybatis.mapper.second.TestMapper2;
import com.zht.springboot_mybatis.service.ITestServie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements ITestServie {

    @Resource
    TestMapper testMapper;

    @Resource
    TestMapper2 testMapper2;

    @Override
    public User getUserInfo(int id) {
        return testMapper.getUser(id);
    }

    @Override
    public List<User> getUserAll() {
        return testMapper.getUserAll();
    }

    @Override
    public void createUserInfo(int id, String name) {
        testMapper.createUser(new User(id,name));
    }

    @Override
    public void deleteUserInfo(int id) {
        testMapper.deleteUser(id);
    }

    @Override
    public void updateUserInfo(int id, String name) {
        testMapper.updateUser(id, name);
    }

    @Override
    public User getUserInfo2(int id) {
        return testMapper2.getUser(id);
    }
}
