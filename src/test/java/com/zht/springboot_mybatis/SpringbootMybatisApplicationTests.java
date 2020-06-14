package com.zht.springboot_mybatis;

import com.zht.springboot_mybatis.mapper.first.TestMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Resource
    TestMapper testMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void getUser(){
        int id = 1;
        System.out.println(testMapper.getUser(id));;
    };

}
