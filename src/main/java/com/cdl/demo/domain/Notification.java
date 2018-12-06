package com.cdl.demo.domain;

import java.util.Date;

public class Notification {
    private Integer notificationClassId;
    private Integer notificationUserId;
    private String notificationTitle;
    private String notificationContent;
    private Date notificationTime;
    private User notificationUser;

    public User getNotificationUser() {
        return notificationUser;
    }

    public void setNotificationUser(User notificationUser) {
        this.notificationUser = notificationUser;
    }

    public Integer getNotificationClassId() {
        return notificationClassId;
    }

    public void setNotificationClassId(Integer notificationClassId) {
        this.notificationClassId = notificationClassId;
    }

    public Integer getNotificationUserId() {
        return notificationUserId;
    }

    public void setNotificationUserId(Integer notificationUserId) {
        this.notificationUserId = notificationUserId;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public Date getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(Date notificationTime) {
        this.notificationTime = notificationTime;
    }
}
