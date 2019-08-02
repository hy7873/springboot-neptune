package com.hy.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hy.service.UserStatusService;
import com.hy.service.YyBorrowService;
import org.springframework.stereotype.Service;

/**
 * @author fengzhengjun
 * @Description
 * @Email fengzhengjun@chinazyjr.com
 * Created on 2017/8/30 13:30
 * Copyright (c) 2017 All Rights Reserved.
 */
@Service
public class UserStatusServiceImpl implements UserStatusService {

    @Reference
    private YyBorrowService yyBorrowService;

    @Override
    public void userTest() {
        yyBorrowService.test1();
    }
}
