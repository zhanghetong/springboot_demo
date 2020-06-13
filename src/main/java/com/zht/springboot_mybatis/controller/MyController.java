package com.zht.springboot_mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.zht.springboot_mybatis.service.ITestServie;
import com.zht.springboot_mybatis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MyController {
    @Autowired
    ITestServie itestsServie;

    @Resource
    RedisUtil redisUtil;

    @RequestMapping(path = "/testa")
    @ResponseBody
    public String testa(){
        return "aa";
    }

    @RequestMapping(path = "/creatUser")
    @ResponseBody
    public String getUser(@RequestParam int id,
                          @RequestParam String name){
        itestsServie.createUserInfo(id,name);
        return "success";
    }

    @RequestMapping(path = "/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam int id){
        itestsServie.deleteUserInfo(id);
        return "success";
    }

    @RequestMapping(path = "/updateUser")
    @ResponseBody
    public String updateUser(@RequestParam int id,
                             @RequestParam String name){
        itestsServie.updateUserInfo(id,name);
        return "success";
    }

    @RequestMapping(path = "/getUser")
    @ResponseBody
    public String getUser(@RequestParam int id){
        return itestsServie.getUserInfo(id).toString();
    }

    @RequestMapping(path = "/getUserAll")
    @ResponseBody
    public String getUserAll(){
        return JSON.toJSONString(itestsServie.getUserAll());
    }


    @RequestMapping(path = "/getUser2")
    @ResponseBody
    public String getUser2(@RequestParam int id){
        return itestsServie.getUserInfo2(id).toString();
    }

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
