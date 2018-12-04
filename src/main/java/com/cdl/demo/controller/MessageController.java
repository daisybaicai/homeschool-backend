package com.cdl.demo.controller;

import com.cdl.demo.domain.Message;
import com.cdl.demo.domain.Result;
import com.cdl.demo.utils.MessageSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageSystem messageSystem;

    @GetMapping(value = "", params = {"fromUserId", "toUserId"})
    public Result getPersonalMessageList(int fromUserId, int toUserId) {
        return messageSystem.getPersonalMessageList(fromUserId, toUserId);
    }

    @PostMapping(value = "/personal")
    public Result sendPersonalMessage(@RequestBody Message message){
        return messageSystem.sendPersonalMessage(message);
    }

    @PostMapping(value = "/class")
    public Result sendClassMessage(@RequestBody Message message){
        return messageSystem.sendClassMessage(message);
    }

    @GetMapping(value = "", params = {"classId"})
    public Result getClassMessageList(int classId) {
        return messageSystem.getClassMessageList(classId);
    }

    @GetMapping(value = "", params = {"userId", "classId"})
    public Result getMessageRecordOfOne(int userId, int classId) {
        return messageSystem.getMessageRecordOfOne(userId, classId);
    }
}
