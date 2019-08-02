package com.hy.mq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wanghai
 * @Date:2019/7/4 10:02
 * @Copyright:reach-life
 * @Description:
 */
@Configuration
public class ExchangeConfig {

    @Bean
    public DirectExchange directExchange() {
        DirectExchange directExchange = new DirectExchange(RabbitMqConfig.EXCHANGE,true,false);
        return directExchange;
    }

}
