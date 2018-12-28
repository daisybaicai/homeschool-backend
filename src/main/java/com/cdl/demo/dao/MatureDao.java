package com.cdl.demo.dao;

import com.cdl.demo.domain.Mature;
import com.cdl.demo.domain.News;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MatureDao {
    List<Mature> getMatureByTime(@Param("userId") int userId);
    List<Mature> getMatureByGroup(@Param("userId") int userId,@Param("grouping") String grouping);
    List<Mature> getMatureByNewsUserId(@Param("userId") int userId,@Param("newsUserId") int newsUserId);

    int sendMature (Mature mature);
    int deleteMature (Mature mature);
}
