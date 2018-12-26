package com.cdl.demo.service.impl;

import com.cdl.demo.dao.ConcernDao;
import com.cdl.demo.domain.Concern;
import com.cdl.demo.domain.User;
import com.cdl.demo.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcernServiceImpl implements ConcernService {

    @Autowired
    private ConcernDao concernDao;

    @Override
    public List<Concern> getUserStarConcern(Integer userId) {
        List<Concern> users= concernDao.getUserStarConcern(userId);
        return users;
    }

    @Override
    public List<Concern> getUserAllConcern(Integer userId) {
        List<Concern> users = concernDao.getUserAllConcern(userId);
        return users;
    }

    @Override
    public List<User> getAllUser(Integer userId) {
        List<User> users = concernDao.getAllUser(userId);
        return users;
    }

    @Override
    public boolean removeConcernsStar(Integer userId, Integer concernedId) {
        concernDao.removeConcernsStar(userId,concernedId);
        return true;
    }

    @Override
    public boolean sendConcernStar(Integer userId, Integer concernedId) {
        concernDao.sendConcernStar(userId,concernedId);
        return true;
    }

    @Override
    public boolean deleteConcern(Integer userId, Integer concernedId) {
        concernDao.deleteConcern(userId,concernedId);
        return true;
    }

    @Override
    public boolean sendConcern(Integer userId, Integer concernedId) {
        concernDao.sendConcern(userId,concernedId);
        return true;
    }
}
