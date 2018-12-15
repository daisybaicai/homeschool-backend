package com.cdl.demo.domain;

import java.io.Serializable;

public class Like implements Serializable {
    private static final long serialVersionUID = -7898194272883238670L;

    public static final String OBJECT_KEY = "LIKE";

    private  int likeNewsId;
    private  int likeUserId;
    private  int likeType;

    @Override
    public String toString() {
        return "Like{" +
                "likeNewsId=" + likeNewsId +
                ", likeUserId=" + likeUserId +
                ", likeType=" + likeType +
                '}';
    }

    public int getLikeNewsId() {
        return likeNewsId;
    }

    public void setLikeNewsId(int likeNewsId) {
        this.likeNewsId = likeNewsId;
    }

    public int getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(int likeUserId) {
        this.likeUserId = likeUserId;
    }

    public int getLikeType() {
        return likeType;
    }

    public void setLikeType(int likeType) {
        this.likeType = likeType;
    }



}
