package com.cdl.demo.dao;

import com.cdl.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserDao {
    User queryUserById(Integer userId);
    List<User> queryUserByMultipleConditions(@Param("startTime")Timestamp startTime,
                                             @Param("endTime") Timestamp endTime,
                                             @Param("userName") String userName,
                                             @Param("userPassword") String userPassword,
                                             @Param("userType") String userType);
    int addUser(User user);
    int updateUserHead(@Param("userId") int userId,@Param("userHeadUrl") String userHeadUrl);
}
