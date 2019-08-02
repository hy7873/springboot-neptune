package com.zhongying.fiance_hg.dto;

import java.io.Serializable;

/**
 * @author lijia
 * @Description 短信验证Dto
 * @Email lijia@chinazyjr.com
 */
public class ValidateSmsDto implements Serializable {

    private static final long serialVersionUID = 1533543554159158468L;

    /**
     * 手机号
     */
    private String phoneNum;
    /**
     * 图形验证码唯一标识
     */
    private String token;
    /**
     * 短信操作类型
     */
    private String operationType;
    /**
     * 图形验证码
     */
    private String imageCode;
    /**
     * 平台
     */
    private String platform;
    /**
     * 短信验证码
     */
    private String smsCode;


    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
