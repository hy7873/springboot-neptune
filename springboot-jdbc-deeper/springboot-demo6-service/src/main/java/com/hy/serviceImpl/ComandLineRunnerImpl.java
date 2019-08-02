package com.hy.serviceImpl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/17.
 */
@Component
@Order(1)
public class ComandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(strings);
    }
}
