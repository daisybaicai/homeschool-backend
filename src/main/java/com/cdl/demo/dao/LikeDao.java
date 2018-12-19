package com.cdl.demo.dao;

import com.cdl.demo.domain.Like;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface LikeDao {

    int sendLike(Like like);

    int delteLike(Like like);
}
