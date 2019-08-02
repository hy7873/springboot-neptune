package com.hy.service.impl;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @Author: wanghai
 * @Date:2019/6/1 18:09
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class TestExitCodeGenerator implements ExitCodeGenerator{

    @Override
    public int getExitCode() {
        System.out.println("----- exit spring boot -----");
        return 42;
    }


}
