package com.hy.controller;

import com.hy.model.UserEvent;
import com.hy.service.UserEventServiceImpl;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wanghai
 * @Date:2019/9/6 10:11
 * @Copyright:reach-life
 * @Description:
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserEventServiceImpl userEventService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @RequestMapping(value = "test1")
    public Map<String,Object> test1() {
        UserEvent userEvent = new UserEvent();
        userEvent.setId(1L);
        userEvent.setUserId("1000");
        userEvent.setDeviceId("xxxxx");
        userEvent.setDate(new Date());
        userEvent.setAction("cccc");
        userEventService.save(userEvent);
        Map<String,Object> map = new HashMap<>();
        map.put("code","success");
        return map;
    }

    @RequestMapping(value = "test2")
    public Map<String,Object> test2() {
        Map<String,Object> map = new HashMap<>();
        SearchRequestBuilder searchRequestBuilder = elasticsearchTemplate.getClient().prepareSearch("user_action_index");
        searchRequestBuilder.setTypes("user_event");
        SearchResponse response = searchRequestBuilder.get();
        SearchHits searchHits = response.getHits();
        StringBuilder stringBuilder = new StringBuilder();
        for (SearchHit searchHit : searchHits) {
            stringBuilder.append(searchHit.getSourceAsString()) ;
        }
        map.put("ret",stringBuilder.toString());
        return map;
    }

}
