package com.hy;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.hy.dao.TbUserMapper;
import com.hy.model.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo1ApplicationTests {

	@Autowired
	private TbUserMapper userMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
		System.out.println(userMapper);
	}

	@Test
	public void testJdbc() {
	    int i = jdbcTemplate.update("update user set user_code = ? where id = ?","ccc",1);
        System.out.println("i = " + i);
    }

}
