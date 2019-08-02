package com.hy.dao;



import com.hy.model.User;
import org.jboss.logging.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper{

    List<Map> findUsersByParams(Map params);

    List<Map> queryUserInfo(Map<String, Object> params);

    int queryUserInfoCount(Map<String, Object> params);

    List<Map> queryUserInfoAll(Map<String, Object> params);

    int queryUserInfoCountAll(Map<String, Object> params);

    /**
     * 根据平台类型 统计累计历史注册用户数
     *
     * @return
     */
}
