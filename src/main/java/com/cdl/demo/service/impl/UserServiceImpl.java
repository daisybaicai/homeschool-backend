package com.cdl.demo.service.impl;

import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.Result;
import com.cdl.demo.domain.User;
import com.cdl.demo.enums.ResultEnum;
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
            startTimeTimeStamp = new Timestamp(new Long(startTime));
        }
        if (endTime != null) {
            endTimeTimeStamp = new Timestamp(new Long(endTime));
        }
        return userDao.queryUserByMultipleConditions(startTimeTimeStamp, endTimeTimeStamp, userName, null, userType);
    }

    @Override
    public User addUser(User user) {
        if (userDao.addUser(user) == 1) {
            return user;
        } else  {
            return  null;
        }
    }

    @Override
    public Result login(String userName, String userPassword) {
        if (userName == null || userPassword == null) {
            return new Result(ResultEnum.ERROR);
        } else {
            List<User> user = userDao.queryUserByMultipleConditions(null, null, userName, userPassword, null);
            if (user.size() == 0) {
                return new Result(ResultEnum.ERROR);
            } else {
                return new Result<>(ResultEnum.SUCCESS, user.get(0));
            }
        }
    }

    @Override
    public int modifyUserHead(int userId, String userHeadUrl) {
        return userDao.updateUserHead(userId, userHeadUrl);
    }
}
