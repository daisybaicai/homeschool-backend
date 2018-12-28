package com.cdl.demo.service.impl;

import com.cdl.demo.dao.*;
import com.cdl.demo.domain.Notification;
import com.cdl.demo.domain.PersonalInformation;
import com.cdl.demo.service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonalInformationServicelImpl implements PersonalInformationService {

    @Autowired
    private PersonalInformationDao personalInformationDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private ConcernDao concernDao;

    @Autowired
    private UserDao userDao;


    @Autowired
    private NotificationDao notificationDao;

    @Override
    public PersonalInformation getInformationByUserId(Integer userId) {
        PersonalInformation personalInformation= personalInformationDao.getInformationByUserId(userId);
        if(personalInformation.getAddress()==null) personalInformation.setAddress("请添加信息");
        if(personalInformation.getJianjie()==null) personalInformation.setJianjie("请添加信息");
        if (personalInformation.getPhone()==null) personalInformation.setPhone("请添加信息");
        if (personalInformation.getInterest()==null) personalInformation.setInterest("请添加信息");
        if (personalInformation.getWork()==null) personalInformation.setWork("请添加信息");
        return personalInformation;
    }

    @Override
    public boolean changeJianjie(Integer userId, String jianjie) {
        personalInformationDao.changeJianjie(userId,jianjie);
        return true;
    }

    @Override
    public boolean changeAddress(Integer userId, String address) {
        personalInformationDao.changeAddress(userId,address);
        return true;
    }

    @Override
    public boolean changePhone(Integer userId, String phone) {
        personalInformationDao.changePhone(userId,phone);
        return true;
    }

    @Override
    public boolean changeInterest(Integer userId, String interest) {
        personalInformationDao.changeInterest(userId,interest);
        return true;
    }

    @Override
    public boolean changeWork(Integer userId, String work) {
        personalInformationDao.changeWork(userId,work);
        return true;
    }

    @Override
    public Map<String, Object> getPersonalByUserId(int userId,int classId) {
        Map<String,Object> map = new HashMap<>();
        int guanzhu = concernDao.getUserConcerenCount(userId);
        int fans = concernDao.getUserConcerenedCount(userId);
        int weibo = newsDao.getAllNewsCountByUserId(userId);
        Notification notification = notificationDao.queryOneNotificationByClassId(classId);
        notification.setNotificationUser(userDao.queryUserById(notification.getNotificationUserId()));
        map.put("guanzhu",guanzhu);
        map.put("fans",fans);
        map.put("weibo",weibo);
        map.put("note",notification);
        return map;
    }


}
