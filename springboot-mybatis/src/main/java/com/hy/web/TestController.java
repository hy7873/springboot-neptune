package com.hy.web;

import com.hy.model.Account;
import com.hy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/6/18 22:41
 * @Copyright:reach-life
 * @Description:
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("findAccountList")
    @ResponseBody
    public List<Account> findAccountList() {
        return accountService.findAccountList();
    }


    @RequestMapping("updateAccount")
    @ResponseBody
    public void updateAccount() {
        accountService.updateAccount();
    }

}
