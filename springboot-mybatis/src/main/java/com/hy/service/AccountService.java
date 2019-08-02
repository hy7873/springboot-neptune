package com.hy.service;

import com.hy.dao.AccountDao;
import com.hy.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/6/18 22:39
 * @Copyright:reach-life
 * @Description:
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAccountList() {
        return accountDao.findAccountList();
    }


    @Transactional
    public int updateAccount() {
        accountDao.update(0.01,1);
        //int i = 1/0;
        accountDao.update(0.02,1);
        return 0;
    }

}
