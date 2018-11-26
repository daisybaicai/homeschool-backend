package com.cdl.demo.controller;

import com.cdl.demo.domain.Result;
import com.cdl.demo.domain.User;
import com.cdl.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(value = "")
    public List<User> getUserByMultipleConditions(String startTime, String endTime, String userName, String userType) {
        return userService.getUserByMultipleConditions(startTime, endTime, userName, userType);
    }

    @PostMapping(value = "")
    public Result<User> addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new Result<User>(-1,bindingResult.getFieldError().getDefaultMessage());
        }
        else {
            return new Result<User>(0,"添加成功",userService.addUser(user));

        }
    }
}
