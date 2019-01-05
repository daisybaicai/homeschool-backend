package com.cdl.demo.controller;

import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "", params = {"classId"})
    public Result getNotificationByClassId(int classId) {
        return new Result<>(ResultEnum.SUCCESS, notificationService.getNotificationByClassId(classId));
    }


}
