package com.hy.dao;

import com.hy.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/6/18 22:37
 * @Copyright:reach-life
 * @Description:
 */
@Mapper
public interface AccountDao {

    List<Account> findAccountList();

    int update(@Param("money") double money, @Param("id") int  id);

}
