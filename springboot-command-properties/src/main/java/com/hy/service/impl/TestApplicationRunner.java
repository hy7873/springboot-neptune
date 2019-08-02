package com.hy.service.impl;

import com.google.gson.Gson;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: wanghai
 * @Date:2019/6/1 18:00
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class TestApplicationRunner implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        //System.out.println(new Gson().toJson(applicationArguments.getOptionNames()));
    }
}
