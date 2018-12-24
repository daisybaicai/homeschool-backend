package com.cdl.demo.dao;

import com.cdl.demo.domain.Mature;
import com.cdl.demo.domain.News;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MatureDao {
    List<Mature> getMatureByTime(@Param("userId") int userId,@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    int sendMature (Mature mature);

}
