package com.zht.springboot_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hetong.zhang
 * @version 1.0
 * @date 2021/1/10
 */
@RestController
public class KafkaController {

    @Value("${spring.kafka.topic}")
    String topic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/sendKafkaMsg")
    public String sendKafkaMsg(@RequestParam String message){
        kafkaTemplate.send(topic, message);
        return "success send " + message;
    }
}
