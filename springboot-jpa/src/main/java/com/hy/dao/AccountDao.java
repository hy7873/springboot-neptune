package com.hy.dao;

import com.hy.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: wanghai
 * @Date:2019/6/4 21:40
 * @Copyright:reach-life
 * @Description:
 */
public interface AccountDao extends JpaRepository<Account,Integer>{

}
