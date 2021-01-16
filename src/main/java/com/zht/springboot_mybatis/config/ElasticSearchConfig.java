package com.zht.springboot_mybatis.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hetong.zhang
 * @version 1.0
 * @date 2021/1/16
 */
@Configuration
public class ElasticSearchConfig {
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient	client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")));
        return client;
    }
}
