package com.cdl.demo.service.impl;

import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.User;
import com.cdl.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;


    @Override
    public User getUserById(int userId) {
        return userDao.queryUserById(userId);
    }

    @Override
    public List<User> getUserByMultipleConditions(String startTime, String endTime, String userName, String userType) {
        Timestamp startTimeTimeStamp = null;
        Timestamp endTimeTimeStamp = null;
        if (startTime != null) {
            startTimeTimeStamp = Timestamp.valueOf(startTime);
        }
        if (endTime != null) {
            endTimeTimeStamp = Timestamp.valueOf(endTime);
        }
        return userDao.queryUserByMultipleConditions(startTimeTimeStamp, endTimeTimeStamp, userName, userType);
    }

    @Override
    public User addUser(User user) {
        if (userDao.addUser(user) == 1) {
            return user;
        } else  {
            return  null;
        }
    }
}
