package com.zht.springboot_mybatis.controller;

import com.zht.springboot_mybatis.utils.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author hetong.zhang
 * @version 1.0
 * @date 2021/1/10
 */
@Controller
public class RedisController {
    @Resource
    RedisUtil redisUtil;

    @RequestMapping(path = "/getRedis")
    @ResponseBody
    public String getRedis(@RequestParam String key){
        String res = (String) redisUtil.get(key);
        return res;
    }

    @RequestMapping(path = "/setRedis")
    @ResponseBody
    public String setRedis(@RequestParam String key, @RequestParam String value){
        boolean ok = redisUtil.set(key,value);
        return "success";
    }
}
