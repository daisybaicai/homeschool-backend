package com.cdl.demo.service.impl;

import com.cdl.demo.dao.CommentDao;
import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.Comment;
import com.cdl.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;
    @Override
    public List<Comment> queryCommentByNewsId(int newId) {
        List<Comment> comments = commentDao.queryCommentByNewsId(newId);
        for (Comment c :
                comments) {
            c.setCommentUser(userDao.queryUserById(c.getCommentUserId()));
            if (c.getCommentType()==1){
                c.setReplyUser(userDao.queryUserById(commentDao.queryCommentUserIdByCommentId(c.getCommentTargetId())));
            }
        }
        return comments;
    }

    @Override
    public int sendComment(Comment comment) {
        commentDao.sendComment(comment);
        return 0;
    }

    @Override
    public List<Comment> queryCommentByUserId(int userId) {
        return commentDao.queryCommentByUserId(userId);
    }

    @Override
    public int deleteCommentById(int commentId) {
        return commentDao.deleteCommentById(commentId);
    }
}
