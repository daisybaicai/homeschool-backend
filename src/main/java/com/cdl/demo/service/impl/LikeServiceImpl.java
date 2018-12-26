package com.cdl.demo.service.impl;

import com.cdl.demo.dao.LikeDao;
import com.cdl.demo.domain.Like;
import com.cdl.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao likeDao;

    @Override
    public int sendLike(Like like) {
        return likeDao.sendLike(like);
    }

    @Override
    public int delteLike(Like like) {
        return likeDao.delteLike(like);
    }

    @Override
    public List queryLikeByNewsId(int newsId) {
        return likeDao.queryLikeByNewsId(newsId);
    }
}
