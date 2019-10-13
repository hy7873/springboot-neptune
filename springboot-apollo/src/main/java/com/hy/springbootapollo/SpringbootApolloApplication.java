package com.hy.springbootapollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.hy.springbootapollo.config.ConfigUtil;
import com.hy.springbootapollo.encrypt.RsaUtil;
import com.hy.springbootapollo.encrypt.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableApolloConfig
public class SpringbootApolloApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootApolloApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApolloApplication.class, args);
    }

    @Value("${apihost1}")
    private String apihost1;

    @RequestMapping("/")
    public String home() {
        try {
            PrivateKey privateKey = RsaUtil.loadPrivateKey(ConfigUtil.getConfig("privateKey"));
            logger.info("privateKey = {}",privateKey);

            Map<String,Object> map = new HashMap<>();
            map.put("aa",1);
            logger.info("sign = {}",SignUtil.getSiginature(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apihost1;
    }
}
