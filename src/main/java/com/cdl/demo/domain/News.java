package com.cdl.demo.domain;

import java.util.Date;

public class News {
    private Integer newsId;
    private Integer newsUserId;
    private String newsContent;
    private Date newsUploadTime;
    private User newsUser;
    private String newsImageURLs;
    private String newsVideoURLs;
    private Integer newsLikeornotlike;
    private Integer newLikeNum;

    public Integer getNewsLikeornotlike() {
        return newsLikeornotlike;
    }

    public void setNewsLikeornotlike(Integer newsLikeornotlike) {
        this.newsLikeornotlike = newsLikeornotlike;
    }

    public Integer getNewLikeNum() {
        return newLikeNum;
    }

    public void setNewLikeNum(Integer newLikeNum) {
        this.newLikeNum = newLikeNum;
    }


    public String getNewsImageURLs() {
        return newsImageURLs;
    }

    public void setNewsImageURLs(String newsImageURLs) {
        this.newsImageURLs = newsImageURLs;
    }

    public String getNewsVideoURLs() {
        return newsVideoURLs;
    }

    public void setNewsVideoURLs(String newsVideoURLs) {
        this.newsVideoURLs = newsVideoURLs;
    }

    public User getNewsUser() {
        return newsUser;
    }

    public void setNewsUser(User newsUser) {
        this.newsUser = newsUser;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getNewsUserId() {
        return newsUserId;
    }

    public void setNewsUserId(Integer newsUserId) {
        this.newsUserId = newsUserId;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getNewsUploadTime() {
        return newsUploadTime;
    }

    public void setNewsUploadTime(Date newsUploadTime) {
        this.newsUploadTime = newsUploadTime;
    }
}
