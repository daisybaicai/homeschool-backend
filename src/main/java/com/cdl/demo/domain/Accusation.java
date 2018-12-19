package com.cdl.demo.domain;

import java.sql.Timestamp;

public class Accusation {
    private int accusationId;
    private int accusationUserId;
    private String accusationType;
    private int accusationNewsId;
    private int accusationCommentId;
    private Timestamp accusationTime;
    private String accusationIntro;

    @Override
    public String toString() {
        return "Accusation{" +
                "accusationId=" + accusationId +
                ", accusationUserId=" + accusationUserId +
                ", accusationType='" + accusationType + '\'' +
                ", accusationNewsId=" + accusationNewsId +
                ", accusationCommentId=" + accusationCommentId +
                ", accusationTime=" + accusationTime +
                ", accusationIntro='" + accusationIntro + '\'' +
                '}';
    }

    public int getAccusationId() {
        return accusationId;
    }

    public void setAccusationId(int accusationId) {
        this.accusationId = accusationId;
    }

    public int getAccusationUserId() {
        return accusationUserId;
    }

    public void setAccusationUserId(int accusationUserId) {
        this.accusationUserId = accusationUserId;
    }

    public String getAccusationType() {
        return accusationType;
    }

    public void setAccusationType(String accusationType) {
        this.accusationType = accusationType;
    }

    public int getAccusationNewsId() {
        return accusationNewsId;
    }

    public void setAccusationNewsId(int accusationNewsId) {
        this.accusationNewsId = accusationNewsId;
    }

    public int getAccusationCommentId() {
        return accusationCommentId;
    }

    public void setAccusationCommentId(int accusationCommentId) {
        this.accusationCommentId = accusationCommentId;
    }

    public Timestamp getAccusationTime() {
        return accusationTime;
    }

    public void setAccusationTime(Timestamp accusationTime) {
        this.accusationTime = accusationTime;
    }

    public String getAccusationIntro() {
        return accusationIntro;
    }

    public void setAccusationIntro(String accusationIntro) {
        this.accusationIntro = accusationIntro;
    }
}
