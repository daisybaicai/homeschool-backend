package com.cdl.demo.service.impl;

import com.cdl.demo.dao.NotificationDao;
import com.cdl.demo.dao.UserDao;
import com.cdl.demo.domain.Notification;
import com.cdl.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Notification> getNotificationByClassId(int classId) {
        List<Notification> notificationList = notificationDao.queryNotificationByClassId(classId);
        for (Notification notification:notificationList) {
            notification.setNotificationUser(userDao.queryUserById(notification.getNotificationUserId()));
        }
        return notificationList;
    }
}
