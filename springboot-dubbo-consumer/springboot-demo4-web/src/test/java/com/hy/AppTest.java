package com.hy;

import com.google.gson.Gson;
import com.hy.service.UserStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest
{

    @Autowired
    private UserStatusService userStatusService;

    @Test
    public void test() {
        userStatusService.userTest();
    }
}
