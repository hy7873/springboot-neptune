package com.hy.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: wanghai
 * @Date:2019/6/27 22:35
 * @Copyright:reach-life
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "测试1",notes = "用于测试")
    @RequestMapping(value = "test1",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> test1(@RequestBody Map<String,Object> map) {
        map.put("a",1);
        map.put("b",2);
        return map;
    }

}
