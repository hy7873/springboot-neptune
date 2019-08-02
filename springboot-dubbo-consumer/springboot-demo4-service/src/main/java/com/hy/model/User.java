package com.hy.model;

import java.util.Date;


public class User {
    /**
     * 数据库主键
     */
    private Long id;

    /**
     * 平台用户编号
     */
    private String userCode;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 手势密码
     */
    private Long gesturePassword;

    /**
     * 用户类型： 1:普通用户 2:企业用户
     */
    private Byte type;

    /**
     * 状态 1:正常 2:锁定
     */
    private Byte status;

    /**
     * 开户状态 1:未开户 3:已开户 4:待激活(汇付开户，已绑卡，未设置交易密码),5 开户未绑卡
     */
    private Byte openAccountStatus;

    /**
     * 平台
     */
    private String platform;

    /**
     * 客户端 1pc 2微信 3iOS 4安卓
     */
    private Byte client;

    /**
     * 版本号
     */
    private String version;

    /**
     * 渠道
     */
    private Integer channal;

    /**
     * 注册时使用的邀请码
     */
    private String registerCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * openid
     */
    private String openid;

    /**
     * 城市
     */
    private String city;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像URL
     */
    private String headimgurl;

    /**
     * 作业账户标识
     */
    private String accountOrgId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取数据库主键
     *
     * @return id - 数据库主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置数据库主键
     *
     * @param id 数据库主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取平台用户编号
     *
     * @return user_code - 平台用户编号
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置平台用户编号
     *
     * @param userCode 平台用户编号
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手势密码
     *
     * @return gesture_password - 手势密码
     */
    public Long getGesturePassword() {
        return gesturePassword;
    }

    /**
     * 设置手势密码
     *
     * @param gesturePassword 手势密码
     */
    public void setGesturePassword(Long gesturePassword) {
        this.gesturePassword = gesturePassword;
    }

    /**
     * 获取用户类型： 1:普通用户 2:企业用户
     *
     * @return type - 用户类型： 1:普通用户 2:企业用户
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置用户类型： 1:普通用户 2:企业用户
     *
     * @param type 用户类型： 1:普通用户 2:企业用户
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取状态 1:正常 2:锁定
     *
     * @return status - 状态 1:正常 2:锁定
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 1:正常 2:锁定
     *
     * @param status 状态 1:正常 2:锁定
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取开户状态 1:未开户 3:已开户 4:待激活(汇付开户，已绑卡，未设置交易密码),5 开户未绑卡
     *
     * @return open_account_status - 开户状态 1:未开户 3:已开户 4:待激活(汇付开户，已绑卡，未设置交易密码),5 开户未绑卡
     */
    public Byte getOpenAccountStatus() {
        return openAccountStatus;
    }

    /**
     * 设置开户状态 1:未开户 3:已开户 4:待激活(汇付开户，已绑卡，未设置交易密码),5 开户未绑卡
     *
     * @param openAccountStatus 开户状态 1:未开户 3:已开户 4:待激活(汇付开户，已绑卡，未设置交易密码),5 开户未绑卡
     */
    public void setOpenAccountStatus(Byte openAccountStatus) {
        this.openAccountStatus = openAccountStatus;
    }

    /**
     * 获取平台
     *
     * @return platform - 平台
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 设置平台
     *
     * @param platform 平台
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * 获取客户端 1pc 2微信 3iOS 4安卓
     *
     * @return client - 客户端 1pc 2微信 3iOS 4安卓
     */
    public Byte getClient() {
        return client;
    }

    /**
     * 设置客户端 1pc 2微信 3iOS 4安卓
     *
     * @param client 客户端 1pc 2微信 3iOS 4安卓
     */
    public void setClient(Byte client) {
        this.client = client;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取渠道
     *
     * @return channal - 渠道
     */
    public Integer getChannal() {
        return channal;
    }

    /**
     * 设置渠道
     *
     * @param channal 渠道
     */
    public void setChannal(Integer channal) {
        this.channal = channal;
    }

    /**
     * 获取注册时使用的邀请码
     *
     * @return register_code - 注册时使用的邀请码
     */
    public String getRegisterCode() {
        return registerCode;
    }

    /**
     * 设置注册时使用的邀请码
     *
     * @param registerCode 注册时使用的邀请码
     */
    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取openid
     *
     * @return openid - openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置openid
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取头像URL
     *
     * @return headimgurl - 头像URL
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * 设置头像URL
     *
     * @param headimgurl 头像URL
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * 获取作业账户标识
     *
     * @return account_org_id - 作业账户标识
     */
    public String getAccountOrgId() {
        return accountOrgId;
    }

    /**
     * 设置作业账户标识
     *
     * @param accountOrgId 作业账户标识
     */
    public void setAccountOrgId(String accountOrgId) {
        this.accountOrgId = accountOrgId;
    }
}