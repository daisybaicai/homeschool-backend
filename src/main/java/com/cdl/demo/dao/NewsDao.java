package com.cdl.demo.dao;

import com.cdl.demo.domain.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface NewsDao {
    int queryNewsAmountByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
    int queryNewsAmountByMonth(@Param("month") int month);
    List<News> queryNewsByUserId(@Param("userId") int userId);
    News queryNewsByNewsId(@Param("newsId") int newsId);
    int queryLikeCount(@Param("newsId") int newsId);

    List<News> queryNewsAll();

    List<News> accordingTime();
    List<News> accordingClass(@Param("userId") int userId);
    List<News> accordingConcern(@Param("userId") int userId);
    List<News> accordingLike();
    int queryNewsLike(@Param("newsId") Integer newsId, @Param("userId") int userId);

    int insertNews(News news);
}
