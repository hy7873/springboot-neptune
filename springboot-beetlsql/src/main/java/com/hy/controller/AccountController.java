package com.hy.controller;

import com.hy.dao.AccountDao;
import com.hy.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/6/4 21:42
 * @Copyright:reach-life
 * @Description:
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Account> findAll() {
        return accountDao.all();
    }

}
