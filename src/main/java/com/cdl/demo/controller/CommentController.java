package com.cdl.demo.controller;

import com.cdl.demo.domain.Comment;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "getNewCommentByNewsId/{newsId}")
    public Result<List<Comment>> getDetailNewsByNewsId(@PathVariable int newsId) {
        return new Result<List<Comment>>(ResultEnum.SUCCESS, commentService.queryCommentByNewsId(newsId));
    }

    @PostMapping(value = "sendComment")
    public Result sendComment(Comment comment, HttpServletRequest request) {
        int result = commentService.sendComment(comment);
        if (result == 1) {
            return new Result(ResultEnum.SUCCESS,"成功");
        } else{
            return new Result(ResultEnum.ERROR,"错误");
        }
    }
}
