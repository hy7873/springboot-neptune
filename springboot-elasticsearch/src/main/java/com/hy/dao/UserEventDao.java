package com.hy.dao;

import com.hy.model.UserEvent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: wanghai
 * @Date:2019/9/5 15:37
 * @Copyright:reach-life
 * @Description:
 */
public interface UserEventDao extends ElasticsearchRepository<UserEvent,Long> {

    public UserEvent queryUserEventById(Long id);

}
