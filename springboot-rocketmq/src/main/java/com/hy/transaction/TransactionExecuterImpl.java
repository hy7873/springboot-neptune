package com.hy.transaction;

import com.alibaba.fastjson.JSONObject;
import com.hy.service.PersonInfoService;
import org.apache.rocketmq.client.producer.LocalTransactionExecuter;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: wanghai
 * @Date:2019/11/29 19:44
 * @Copyright:reach-life
 * @Description:
 */
@Component("transactionExecuterImpl")
public class TransactionExecuterImpl implements LocalTransactionExecuter {

    private PersonInfoService personInfoService = new PersonInfoService();

    public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
        try {
            //Message Body
            JSONObject messageBody = JSONObject.parseObject(new String(msg.getBody(), "utf-8"), JSONObject.class);
            //Transaction MapArgs
            Map<String, Object> mapArgs = (Map<String, Object>) arg;

            // --------------------IN PUT---------------------- //
            System.out.println("message body = " + messageBody);
            System.out.println("message mapArgs = " + mapArgs);
            System.out.println("message tag = " + msg.getTags());
            // --------------------IN PUT---------------------- //
            long userid = messageBody.getLong("userid");
            String face = messageBody.getString("face"); //头像
            String trueName = messageBody.getString("truename"); //姓名
            int gender = messageBody.getInteger("gender"); //性别
            int workClass = messageBody.getInteger("workClass"); //期望职位ID
            int workCity = messageBody.getInteger("workCity");
            personInfoService.savePersonalInfo();
            //成功通知MQ消息变更 该消息变为：<确认发送>

            return LocalTransactionState.COMMIT_MESSAGE;

            //return LocalTransactionState.UNKNOW;

        } catch (Exception e) {
            e.printStackTrace();
            //失败则不通知MQ 该消息一直处于：<暂缓发送>
            return LocalTransactionState.ROLLBACK_MESSAGE;

        }

    }
}