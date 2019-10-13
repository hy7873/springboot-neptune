package com.hy.springbootapollo.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * @Author: wanghai
 * @Date:2019/10/13 9:59
 * @Copyright:reach-life
 * @Description:
 */
public class ConfigUtil {

    public static Config config = ConfigService.getAppConfig();

    public static String getConfig(String key) {
        return config.getProperty(key,"");
    }

}
