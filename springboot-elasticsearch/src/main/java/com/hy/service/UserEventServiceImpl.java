package com.hy.service;

import com.hy.dao.UserEventDao;
import com.hy.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wanghai
 * @Date:2019/9/6 10:02
 * @Copyright:reach-life
 * @Description:
 */
@Service
public class UserEventServiceImpl {

    @Autowired
    private UserEventDao userEventDao;

    public void save(UserEvent userEvent) {
        userEventDao.save(userEvent);
    }

}
