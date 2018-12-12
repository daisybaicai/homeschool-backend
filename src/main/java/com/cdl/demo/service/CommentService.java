package com.cdl.demo.service;

import com.cdl.demo.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> queryCommentByNewsId(int newId);

    int sendComment(Comment comment);
}
