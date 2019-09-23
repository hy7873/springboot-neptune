package com.hy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wanghai
 * @Date:2019/9/5 15:33
 * @Copyright:reach-life
 * @Description:
 */
@Document(indexName = "user_action_index", type = "user_event", shards = 8, replicas = 1)
public class UserEvent implements Serializable{

    @Id
    @Field(type = FieldType.Long,index = true)
    private Long id;

    @Field(type = FieldType.Keyword)
    private String userId;

    @Field(type = FieldType.Keyword)
    private String deviceId;

    @Field(type = FieldType.Date,index = true,store = true)
    private Date date;

    @Field(type = FieldType.Keyword)
    private String action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
