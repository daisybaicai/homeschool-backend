package com.cdl.demo.dao;

import com.cdl.demo.domain.Concern;
import com.cdl.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConcernDao {
    List<Concern> getUserStarConcern(@Param("userId") int userId);
    List<Concern> getUserAllConcern(@Param("userId") int userId);
    List<User> getAllUser(@Param("userId") int userId);
    boolean removeConcernsStar(@Param("userId") int userId, @Param("concernedId") int concernedId);
    boolean sendConcernStar(@Param("userId") int userId, @Param("concernedId") int concernedId);
    boolean deleteConcern(@Param("userId") int userId, @Param("concernedId") int concernedId);
    boolean sendConcern(@Param("userId") int userId, @Param("concernedId") int concernedId);
    int getUserConcerenCount(@Param("userId") int userId);
    int getUserConcerenedCount(@Param("userId") int userId );
}
