package com.cdl.demo.domain;

import java.sql.Timestamp;

public class Comment {
    private int commentId;
    private int commentNewsId;
    private int commentUserId;
    private String commentContent;
    private Timestamp commentTime;
    private int commentTargetId;
    private int commentType;
    private User commentUser;
    private User replyUser;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentNewsId() {
        return commentNewsId;
    }

    public void setCommentNewsId(int commentNewsId) {
        this.commentNewsId = commentNewsId;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public int getCommentTargetId() {
        return commentTargetId;
    }

    public void setCommentTargetId(int commentTargetId) {
        this.commentTargetId = commentTargetId;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }


    public User getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(User replyUser) {
        this.replyUser = replyUser;
    }

    public User getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }
}
