package com.hy.dao;

import com.hy.model.Account;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;

/**
 * @Author: wanghai
 * @Date:2019/6/5 22:31
 * @Copyright:reach-life
 * @Description:
 */
public interface AccountDao extends BaseMapper<Account> {

    @SqlStatement(params = "name")
    Account selectAccountByName(String name);
}

