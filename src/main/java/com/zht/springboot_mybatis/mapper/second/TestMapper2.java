package com.zht.springboot_mybatis.mapper.second;

import com.zht.springboot_mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper2 {

    User getUser(int id);
}
