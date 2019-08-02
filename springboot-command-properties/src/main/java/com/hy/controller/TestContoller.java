package com.hy.controller;

import com.hy.util.constant.IcbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wanghai@chinazyjr.com
 * @Since 2018/6/7
 * @Description
 * @Copyright zyjr
 */
@RestController
@RequestMapping("test")
@EnableConfigurationProperties({IcbcProperties.class})
public class TestContoller {

    @Autowired
    private IcbcProperties icbcProperties;

    @RequestMapping("test1")
    @ResponseBody
    public Map<String,Object> test1(){
        Map<String,Object> map = new HashMap<>();
        map.put("groupName",icbcProperties.getGroupName());
        return map;
    }

    @RequestMapping("testJsp")
    public String testJsp(Map<String,Object> map) {
        map.put("name","wanghai");
        return "hello";
    }


   /* @RequestMapping("testJdbc")
    @ResponseBody
    public List<TbUser> testJdbc() {
        TbUser user = new TbUser();
        user.setUserName("wanghai");
        PageHelper.startPage(2,5);
        List<TbUser> users = userMapper.getListByCondition(user);
        System.out.println(new Gson().toJson(users));
        return users;
    }*/

}
