package com.cdl.demo.domain;

import java.sql.Timestamp;

public class Message {
    private Integer fromUserId;
    private Integer toUserId;
    private String messageContent;
    private Timestamp messageTime;

    @Override
    public String toString() {
        return fromUserId + " " + toUserId + " " + messageContent + " " + messageTime.getTime();
    }

    public Message(Integer fromUserId, Integer toUserId, String messageContent, Timestamp messageTime) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.messageContent = messageContent;
        this.messageTime = messageTime;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }
}
