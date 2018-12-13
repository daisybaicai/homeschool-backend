package com.cdl.demo.service;

import com.cdl.demo.domain.Result;
import com.cdl.demo.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getUserById(int userId);
    List<User> getUserByMultipleConditions(String startTime,
                                             String endTime,
                                             String userName,
                                             String userType);
    User addUser(User user);
    Result login(String userName, String userPassword);
    Map<Integer, User> getClassUserList(int classId);
    int modifyUserHead(int userId, String userHeadUrl);
    String getUserPasswordById(int userId);
    String getUserPasswordByUserName(String userName);
    int updateUserPassword(int userId,String userPassword);
    List getUserRegisterAmountAllMonth();
    Map getUserRegisterAmountByType();
    int deleteUser(int userId);
}
