package com.hy;

import com.google.gson.Gson;
import com.hy.dao.UserMapper;
import com.hy.model.User;
import com.hy.service.UserStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest
{

    @Autowired
    private UserMapper userMapper;

    private final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void test1() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setMobile("158");
        userList = userMapper.getListByConditionLike(user);
        logger.info("测试：{}",1);
        logger.debug("测试：{}",1);
        logger.error("测试：{}",1);
    }
}
