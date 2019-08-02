package com.hy.serviceImpl;

import com.hy.dao.UserMapper;
import com.hy.model.User;
import com.hy.service.YyBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wanghai on 2018/9/22.
 */
@Service
public class YyBorrowServiceImpl implements YyBorrowService{

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void test1() {
        User user = new User();
        user.setId(4714L);
        user = userMapper.getByCondition(user);
        user.setUserCode("44441");
        userMapper.update(user);

        User user1 = new User();
        user1.setId(4715L);
        user1 = userMapper.getByCondition(user1);
        user1.setUserCode("33331");
        userMapper.update(user1);
        System.out.println("provider test1");

        System.out.println(1/0);
    }
}
