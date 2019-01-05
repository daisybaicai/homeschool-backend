package com.cdl.demo.controller;

import com.cdl.demo.domain.Notification;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "", params = {"classId"})
    public Result getNotificationByClassId(int classId) {
        return new Result<>(ResultEnum.SUCCESS, notificationService.getNotificationByClassId(classId));
    }

    @PostMapping(value = "insertNotification")
    public Result sendComment(Notification notification, HttpServletRequest request) {
        int result = notificationService.insertNotification(notification);
        if (result == 0) {
            return new Result(ResultEnum.SUCCESS,"成功");
        } else{
            return new Result(ResultEnum.ERROR,"错误");
        }
    }


}
