package com.hy.springbootapollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.google.inject.internal.cglib.core.$MethodWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApolloApplicationTests {

    private Config config = ConfigService.getAppConfig();

    @Test
    public void contextLoads() {
        String apihost1 = config.getProperty("apihost1","");
        System.out.println(apihost1);
    }

}
