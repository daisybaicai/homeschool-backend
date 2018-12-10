package com.cdl.demo.service.impl;

import com.cdl.demo.dao.NewsDao;
import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.News;
import com.cdl.demo.domain.User;
import com.cdl.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List getNewsAmountAllMonth() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i <= 12; i++) {
            list.add(newsDao.queryNewsAmountByMonth(i));
        }
        return list;
    }

    @Override
    public List<News> getNewsAllByUserIds(int userId) {
        List<News> news = newsDao.queryNewsAll();
        for (int i = 0; i < news.size(); i++) {
            News onenews = news.get(i);
            int newsid = onenews.getNewsId();
            User user = userDao.queryUserById(onenews.getNewsUserId());
            onenews.setNewsUser(user);
            int likeornotlike = newsDao.queryNewsLike(newsid,userId);
            onenews.setNewsLikeornotlike(likeornotlike);
            int likenum = newsDao.queryLikeCount(newsid);
            onenews.setNewLikeNum(likenum);
        }
        return news;
    }

    @Override
    public String insertNews(News news) {
        String result = null;
        if (newsDao.insertNews(news) == 1){
            result = "发布动态成功";
        } else  {
            result = "发布动态失败请重试";
        }
        return result;
    }
}
