package com.cdl.demo.service;

import com.cdl.demo.domain.Comment;
import com.cdl.demo.domain.Like;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {
    int sendLike(Like like);

    int delteLike(Like like);

    List<Like> queryLikeByNewsId(int likeNewsId);
}
