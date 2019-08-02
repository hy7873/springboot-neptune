package com.hy.serviceImpl;

import com.hy.dao.UserMapper;
import com.hy.model.User;
import com.hy.service.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fengzhengjun
 * @Description
 * @Email fengzhengjun@chinazyjr.com
 * Created on 2017/8/30 13:30
 * Copyright (c) 2017 All Rights Reserved.
 */
@Service
public class UserStatusServiceImpl implements UserStatusService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void saveListUser(List<User> userList) {
        for (User itemUser : userList) {
            userMapper.save(itemUser);
        }
    }
}
