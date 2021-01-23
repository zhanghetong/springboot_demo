package com.zht.springboot_mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hetong.zhang
 * @version 1.0
 * @date 2021/1/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2 {
    private int id;
    private String name;
    private int age;
}
