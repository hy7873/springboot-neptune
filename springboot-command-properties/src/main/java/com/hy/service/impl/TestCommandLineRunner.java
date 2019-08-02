package com.hy.service.impl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: wanghai
 * @Date:2019/6/1 17:38
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class TestCommandLineRunner implements CommandLineRunner{

    private ApplicationContext applicationContext;


    TestCommandLineRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public void run(String... strings) throws Exception {
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String beanName : beans) {
            ///System.out.println(beanName);
        }
    }
}
