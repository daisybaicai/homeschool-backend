package com.cdl.demo.domain;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class User {
    private Integer userId;
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "用户密码不能为空")
    private String userPassword;
    @NotNull(message = "用户类型不能为空")
    private String userType;
    private String userHeadUrl;
    private String userCoverUrl;
    private String userNickname;
    private Timestamp userRegisterTime;
    private Integer userClassId;

    public Integer getUserClassId() {
        return userClassId;
    }

    public void setUserClassId(Integer userClassId) {
        this.userClassId = userClassId;
    }

    public Timestamp getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Timestamp userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl;
    }

    public String getUserCoverUrl() {
        return userCoverUrl;
    }

    public void setUserCoverUrl(String userCoverUrl) {
        this.userCoverUrl = userCoverUrl;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
