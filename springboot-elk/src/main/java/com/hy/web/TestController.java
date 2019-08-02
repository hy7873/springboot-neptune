package com.hy.web;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wanghai
 * @Date:2019/7/18 17:52
 * @Copyright:reach-life
 * @Description:
 */
@RestController
public class TestController {

    private Logger logger = Logger.getLogger(getClass());

    @RequestMapping("/")
    public String home() {
        for (int i = 0; i < 1000; i++) {
            logger.info("elk-test-" + i);
            logger.debug("elk-test-" + i);
            logger.error("elk-test-" + i);
        }
        return "elk-test";
    }

}
