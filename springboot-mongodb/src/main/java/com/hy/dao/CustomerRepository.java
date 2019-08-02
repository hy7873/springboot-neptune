package com.hy.dao;

import com.hy.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: wanghai
 * @Date:2019/6/21 16:02
 * @Copyright:reach-life
 * @Description:
 */
public interface CustomerRepository extends MongoRepository<Customer,String>{

    public Customer findById(Integer id);

}
