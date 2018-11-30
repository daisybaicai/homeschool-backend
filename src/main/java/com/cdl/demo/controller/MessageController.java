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

    @GetMapping(value = "")
    public Result getPersonalMessageList(int fromUserId, int toUserId) {
        return messageSystem.getPersonalMessageList(fromUserId, toUserId);
    }

    @PostMapping(value = "")
    public Result sendPersonalMessage(@RequestBody Message message){
        return messageSystem.sendPersonalMessage(message);
    }
}
