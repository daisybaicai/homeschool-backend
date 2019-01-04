package com.cdl.demo.dao;

import com.cdl.demo.domain.Accusation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccuseDao {
    int addAccuse(Accusation accusation);
    List<Accusation> queryUnhandledAccusationByPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
    int updateAccusationStatusById(@Param("accusationId") int accusationId, @Param("accusationStatus") int accusationStatus);
}
