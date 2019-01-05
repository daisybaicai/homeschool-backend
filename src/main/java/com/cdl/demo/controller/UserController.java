package com.cdl.demo.controller;

import com.cdl.demo.domain.Result;
import com.cdl.demo.domain.User;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.RedisService;
import com.cdl.demo.service.UserService;
import com.cdl.demo.utils.MyMailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private MyMailer myMailer;

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

    @GetMapping(value = "", params = {"classId"})
    public Result getUserByClassId(int classId) {
        return new Result<>(ResultEnum.SUCCESS, userService.getClassUserList(classId));
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
    public Result<String> uploadFile(@RequestParam("head") MultipartFile file, @PathVariable int userId) throws FileNotFoundException {
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        String newFileName = userId + "_" + new Date().getTime() + suffix;
        String abp = ResourceUtils.getURL("classpath:static/img/userHead").getPath();
        String path = abp + "/" + newFileName;
        File newFile = new File(path);
        try {
            file.transferTo(newFile);
            userService.modifyUserHead(userId, newFileName);
            return new Result<>(ResultEnum.SUCCESS, newFileName);
        }
        catch (Exception e){
            e.printStackTrace();
            return new Result<>(ResultEnum.ERROR, null);
        }
    }

    @GetMapping(value = "/login")
    public Result login(String userName, String userPassword) {
        return userService.login(userName, userPassword);
    }

    @GetMapping(value = "/code")
    public Result getIdentifyingCode(String email) {
        myMailer.createServer();
        int code = myMailer.addMessage(email);
        myMailer.sendMessage();
        return new Result<>(ResultEnum.SUCCESS, code);
    }

    @GetMapping(value = "/forgetPasswordCode")
    public Result getForgetPasswordCode(String email) {
        myMailer.createServer();
        int code = myMailer.addForgetPasswordEmail(email);
        myMailer.sendMessage();
        redisService.set("verificationCode:" + email, code, (long) (10 * 60));
        return new Result<>(ResultEnum.SUCCESS, null);
    }

    @GetMapping(value = "/password", params = "userId")
    public Result getUserPasswordById(int userId) {
        return new Result<>(ResultEnum.SUCCESS, userService.getUserPasswordById(userId));
    }

    @GetMapping(value = "/password", params = "userName")
    public Result getUserPasswordByUserName(String userName) {
        return new Result<>(ResultEnum.SUCCESS, userService.getUserPasswordByUserName(userName));
    }

    @PutMapping(value = "/password")
    public Result updateUserPassword(int userId, String userPassword) {
        return new Result<>(ResultEnum.SUCCESS, userService.updateUserPassword(userId, userPassword));
    }

    @GetMapping(value = "/monthAmount")
    public Result getUserRegisterAmountAllMonth() {
        return new Result<>(ResultEnum.SUCCESS, userService.getUserRegisterAmountAllMonth());
    }

    @GetMapping(value = "/typeAmount")
    public Result getUserRegisterAmountByType() {
        return new Result<>(ResultEnum.SUCCESS, userService.getUserRegisterAmountByType());
    }

    @DeleteMapping(value = "")
    public Result deleteUser(int userId) {
        return new Result<>(ResultEnum.SUCCESS, userService.deleteUser(userId));
    }
}
