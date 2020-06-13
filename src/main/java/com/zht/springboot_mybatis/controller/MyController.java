package com.zht.springboot_mybatis.controller;

import com.zht.springboot_mybatis.service.ItestsServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @Autowired
    ItestsServie itestsServie;

    @RequestMapping(path = "/testa")
    @ResponseBody
    public String testa(){
        return "aa";
    }

    @RequestMapping(path = "/getUser")
    @ResponseBody
    public String getUser(@RequestParam int id){
        return itestsServie.getUserInfo(id).toString();
    }

    @RequestMapping(path = "/getUser2")
    @ResponseBody
    public String getUser2(@RequestParam int id){
        return itestsServie.getUserInfo2(id).toString();
    }
}
