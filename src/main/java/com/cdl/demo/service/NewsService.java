package com.cdl.demo.service;

import com.cdl.demo.domain.News;

import java.util.Date;
import java.util.List;

public interface NewsService {
    int getNewsAmountByTime(String startTime, String endTime);
    List<News> getNewsByUserId(int userId);
    News getNewsByNewsId(int newsId);
}
