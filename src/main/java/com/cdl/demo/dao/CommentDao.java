package com.cdl.demo.dao;

import com.cdl.demo.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CommentDao {
    List<Comment> queryCommentByNewsId(@Param("commentNewsId") int commentNewsId);

    int queryCommentUserIdByCommentId(@Param("commentTargetId")int commentTargetId);
}
