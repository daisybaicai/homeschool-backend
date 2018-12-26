package com.cdl.demo.controller;

import com.cdl.demo.domain.Like;
import com.cdl.demo.domain.Mature;
import com.cdl.demo.domain.News;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.MatureService;
import com.cdl.demo.service.NewsService;
import com.cdl.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mature")
public class MatureController {

    @Autowired
    private MatureService matureService;


//    根据时间查找成长线记录
    @GetMapping(value = "/getMatureByTime", params = {"userId", "startTime","endTime"})
    public Result<List<Mature>> getMatureByTime(int userId,String startTime,String endTime) {
        return new Result<>(ResultEnum.SUCCESS, matureService.getMatureByTime(userId,startTime,endTime));
    }

    //    根据分组查找成长线记录
    @GetMapping(value = "/getMatureByGroup", params = {"userId", "grouping"})
    public Result<List<Mature>> getMatureByGroup(int userId,String grouping) {
        return new Result<>(ResultEnum.SUCCESS, matureService.getMatureByGroup(userId,grouping));
    }

    //    根据动态的发布人查找成长线记录
    @GetMapping(value = "/getMatureByNewsUserId", params = {"userId", "newsUserId"})
    public Result<List<Mature>> getMatureByNewsUserId(int userId,int newsUserId) {
        return new Result<>(ResultEnum.SUCCESS, matureService.getMatureByNewsUserId(userId,newsUserId));
    }


//    往成长线中添加记录
    @PostMapping(value = "")
    public Result addUser(@Valid @RequestBody Mature mature, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new Result<>(-1,bindingResult.getFieldError().getDefaultMessage());
        }
        else {
            return new Result<>(0,"添加成功",matureService.addMature(mature));

        }
    }

    //从成长线中删除一条记录
    @PostMapping(value = "/deleteMature")
    public Result deleteUser(@Valid @RequestBody Mature mature) {
        return new Result<>(ResultEnum.SUCCESS, matureService.deleteMature(mature));
    }


}

