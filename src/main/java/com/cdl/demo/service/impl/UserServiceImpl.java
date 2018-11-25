package com.cdl.demo.service.impl;

import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.User;
import com.cdl.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;


    @Override
    public User getUserById(int userId) {
        return userDao.queryUserById(userId);
    }
}
