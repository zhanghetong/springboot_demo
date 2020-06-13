package com.zht.springboot_mybatis.service.impl;

import com.zht.springboot_mybatis.entity.User;
import com.zht.springboot_mybatis.mapper.first.TestMapper;
import com.zht.springboot_mybatis.mapper.second.TestMapper2;
import com.zht.springboot_mybatis.service.ItestsServie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements ItestsServie {

    @Resource
    TestMapper testMapper;

    @Resource
    TestMapper2 testMapper2;

    @Override
    public User getUserInfo(int id) {
        return testMapper.getUser(id);
    }

    @Override
    public User getUserInfo2(int id) {
        return testMapper2.getUser(id);
    }
}
