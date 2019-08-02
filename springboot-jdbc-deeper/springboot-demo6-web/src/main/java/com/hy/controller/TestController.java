package com.hy.controller;

import com.hy.service.YyBorrowService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghai on 2018/9/6.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private YyBorrowService yyBorrowService;

    @RequestMapping("test1")
    public void test1() {
        yyBorrowService.test1();
    }

}
