package com.zht.springboot_mybatis.mapper.first;

import com.zht.springboot_mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    User getUser(int id);
}
