package com.cdl.demo.service;

import com.cdl.demo.domain.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getNotificationByClassId(int classId);

    int insertNotification(Notification notification);
}
