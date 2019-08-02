package com.hy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: wanghai
 * @Date:2019/6/24 22:37
 * @Copyright:reach-life
 * @Description:
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String,Object> hello() {
        return Collections.singletonMap("message","hello world");
    }
}
