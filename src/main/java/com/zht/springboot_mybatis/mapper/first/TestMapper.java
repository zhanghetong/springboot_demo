package com.zht.springboot_mybatis.mapper.first;

import com.zht.springboot_mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    void createUser(User user);
    void deleteUser(int id);
    void updateUser(int id, String name);
    User getUser(int id);
    List<User> getUserAll();
}
