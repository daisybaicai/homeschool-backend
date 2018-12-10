package com.cdl.demo.dao;

import com.cdl.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface UserDao {
    User queryUserById(Integer userId);
    List<User> queryUserByMultipleConditions(@Param("startTime")Timestamp startTime,
                                             @Param("endTime") Timestamp endTime,
                                             @Param("userName") String userName,
                                             @Param("userPassword") String userPassword,
                                             @Param("userType") String userType);
    List<User> queryUserByClassId(@Param("classId") int classId);
    String queryUserPasswordById(@Param("userId") int userId);
    int queryUserRegisterAmountByMonth(@Param("month") int month);
    int queryUserRegisterAmountByType(@Param("type") String type);
    int addUser(User user);
    int updateUserHead(@Param("userId") int userId,@Param("userHeadUrl") String userHeadUrl);
    int updateUserPassword(@Param("userId") int userId,@Param("userPassword") String userPassword);
}
