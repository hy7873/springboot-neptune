package com.hy.util.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: wanghai
 * @Date:2019/6/2 18:50
 * @Copyright:reach-life
 * @Description:
 */
@Configuration
@PropertySource("classpath:icbc.properties")
@ConfigurationProperties
public class IcbcProperties {

    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
