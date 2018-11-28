package com.cdl.demo.controller;

import com.cdl.demo.domain.Result;
import com.cdl.demo.domain.User;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}")
    public Result<User> getUserById(@PathVariable int userId) {
        return new Result<>(ResultEnum.SUCCESS, userService.getUserById(userId));
    }

    @GetMapping(value = "")
    public Result<List<User>> getUserByMultipleConditions(String startTime, String endTime, String userName, String userType) {
        return new Result<>(ResultEnum.SUCCESS, userService.getUserByMultipleConditions(startTime, endTime, userName, userType));
    }

    @PostMapping(value = "")
    public Result<User> addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new Result<>(-1,bindingResult.getFieldError().getDefaultMessage());
        }
        else {
            return new Result<>(0,"添加成功",userService.addUser(user));

        }
    }

    @PostMapping(value = "/{userId}/userHead")
    public Result uploadFile(@RequestParam("head") MultipartFile file, @PathVariable int userId) throws FileNotFoundException {
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        String newFileName = userId + "_" + new Date().getTime() + suffix;
        System.out.println(ResourceUtils.getURL("src/main/resources").getPath());
        String abp = ResourceUtils.getURL("src/main/resources").getPath();
        String path = abp + "/static/img/userHead/" + newFileName;
        File newFile = new File(path);
        try {
            file.transferTo(newFile);
            return new Result(ResultEnum.SUCCESS);
        }
        catch (Exception e){
            e.printStackTrace();
            return new Result(ResultEnum.ERROR);
        }
    }
}
