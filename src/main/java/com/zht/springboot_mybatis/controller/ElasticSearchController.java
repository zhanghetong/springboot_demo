package com.zht.springboot_mybatis.controller;


/**
 * @author hetong.zhang
 * @version 1.0
 * @date 2021/1/16
 */

import com.alibaba.fastjson.JSON;
import com.zht.springboot_mybatis.entity.User2;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElasticSearchController {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @PostMapping("/saveEsData")
    public String saveEsData(@RequestBody User2 user2) throws Exception{
        IndexRequest request = new IndexRequest("estest");
        request.source(JSON.toJSONString(user2), XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);

        return indexResponse.toString();
    }

    @GetMapping("searchEsData")
    public String searchData() throws Exception{
        SearchRequest searchRequest = new SearchRequest("estest");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name.keyword","张三");
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("name","张三");
        sourceBuilder.query(queryBuilder);
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(JSON.toJSONString(searchResponse.getHits()));
        return JSON.toJSONString(searchResponse.getHits());
    }
}
