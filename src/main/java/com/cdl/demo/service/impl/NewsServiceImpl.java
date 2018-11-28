package com.cdl.demo.service.impl;

import com.cdl.demo.dao.NewsDao;
import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.News;
import com.cdl.demo.domain.User;
import com.cdl.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private NewsDao newsDao;

    @Override
    public int getNewsAmountByTime(String startTime, String endTime) {
        long sTime = new Long(startTime);
        long eTime = new Long(endTime);
        Date sDate = new Date(sTime);
        Date eDate = new Date(eTime);
        return newsDao.queryNewsAmountByTime(sDate, eDate);
    }

    @Override
    public List<News> getNewsByUserId(int userId) {
        return newsDao.queryNewsByUserId(userId);
    }

    @Override
    public News getNewsByNewsId(int newsId) {
        News news = newsDao.queryNewsByNewsId(newsId);
        User user = userDao.queryUserById(news.getNewsUserId());
        news.setNewsUser(user);
        return news;
    }
}
