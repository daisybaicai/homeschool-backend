package com.cdl.demo.service;

import com.cdl.demo.domain.Result;
import com.cdl.demo.domain.User;

import java.util.List;

public interface UserService {
    User getUserById(int userId);
    List<User> getUserByMultipleConditions(String startTime,
                                             String endTime,
                                             String userName,
                                             String userType);
    User addUser(User user);
    Result login(String userName, String userPassword);
    int modifyUserHead(int userId, String userHeadUrl);
}
