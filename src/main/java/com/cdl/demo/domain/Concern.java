package com.cdl.demo.domain;

import java.util.Date;

public class Concern {
    private Integer Id;
    private String concernId;
    private String concernedId;
    private Date concernTime;
    private String starConcern;
    private User user1;
    private User user2;

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getConcernId() {
        return concernId;
    }

    public void setConcernId(String concernId) {
        this.concernId = concernId;
    }

    public String getConcernedId() {
        return concernedId;
    }

    public void setConcernedId(String concernedId) {
        this.concernedId = concernedId;
    }

    public Date getConcernTime() {
        return concernTime;
    }

    public void setConcernTime(Date concernTime) {
        this.concernTime = concernTime;
    }

    public String getStarConcern() {
        return starConcern;
    }

    public void setStarConcern(String starConcern) {
        this.starConcern = starConcern;
    }
}
