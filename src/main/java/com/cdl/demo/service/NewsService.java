package com.cdl.demo.service;

import com.cdl.demo.domain.News;

import java.util.List;

public interface NewsService {
    int getNewsAmountByTime(String startTime, String endTime);
    List<News> getNewsByUserId(int userId);
    News getNewsByNewsId(int newsId);
    List getNewsAmountAllMonth();

    List<News> getNewsAllByUserIds(int userId);

    List<News> accordingTime(int userId);

    List<News> accordingClass(int userId);
    List<News> accordingConcern(int userId);
    List<News> accordingLike(int userId);
    List<News> getNewByUserId(int userId);
    String insertNews(News news);

    News getDetailNewsByNewsId(int newsId);

    int deleteNewsByNewsId(int newsId);
}
