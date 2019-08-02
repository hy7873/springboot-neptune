package com.hy.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hy.service.YyBorrowService;
import org.springframework.stereotype.Component;

/**
 * Created by wanghai on 2018/9/22.
 */
@Component
@Service
public class YyBorrowServiceImpl implements YyBorrowService{

    @Override
    public void test1() {
        System.out.println("provider test1");
    }
}
