package com.cdl.demo.dao;

import com.cdl.demo.domain.Notification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotificationDao {
    List<Notification> queryNotificationByClassId(@Param("classId") int classId);

    Notification queryOneNotificationByClassId(@Param("classId") int classId);
}
