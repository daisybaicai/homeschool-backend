package com.cdl.demo.dao;

import com.cdl.demo.domain.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface NewsDao {
    int queryNewsAmountByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
    List<News> queryNewsByUserId(@Param("userId") int userId);
    News queryNewsByNewsId(@Param("newsId") int newsId);
    int queryLikeCount(@Param("newsId") int newsId);

    List<News> queryNewsAll();

    int queryNewsLike(@Param("newsId") Integer newsId, @Param("userId") int userId);
}
