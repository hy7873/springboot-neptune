package com.hy.transaction;

import org.apache.rocketmq.client.QueryResult;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: wanghai
 * @Date:2019/11/29 19:42
 * @Copyright:reach-life
 * @Description:
 */

public class MQProducer {

    private final String GROUP_NAME = "xxxx";
    private final String NAMESRV_ADDR = "xxx.xxx.xxx.xxx:9876";
    private TransactionMQProducer producer;

    public MQProducer() {

        this.producer = new TransactionMQProducer(GROUP_NAME);
        this.producer.setNamesrvAddr(NAMESRV_ADDR);    //nameserver服务
        this.producer.setCheckThreadPoolMinSize(5);    // 事务回查最小并发数
        this.producer.setCheckThreadPoolMaxSize(20);   // 事务回查最大并发数
        this.producer.setCheckRequestHoldMax(2000);    // 队列数
        //服务器回调Producer，检查本地事务分支成功还是失败
        this.producer.setTransactionCheckListener(new TransactionCheckListener() {
            public LocalTransactionState checkLocalTransactionState(MessageExt msg) {
                System.out.println("state -- "+ new String(msg.getBody()));
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public QueryResult queryMessage(String topic, String key, int maxNum, long begin, long end) throws Exception {
        return this.producer.queryMessage(topic, key, maxNum, begin, end);
    }

    public LocalTransactionState check(MessageExt me){
        LocalTransactionState ls = this.producer.getTransactionCheckListener().checkLocalTransactionState(me);
        return ls;
    }

    public void sendTransactionMessage(Message message, LocalTransactionExecuter localTransactionExecuter, Map<String, Object> transactionMapArgs) throws Exception {
        TransactionSendResult tsr = this.producer.sendMessageInTransaction(message, localTransactionExecuter, transactionMapArgs);
        System.out.println("send返回内容：" + tsr.toString());
    }

    public void shutdown(){
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                producer.shutdown();
            }
        }));
        System.exit(0);
    }


}
