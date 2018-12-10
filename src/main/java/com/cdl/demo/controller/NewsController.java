package com.cdl.demo.controller;

import com.cdl.demo.domain.News;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/{newsId}")
    public Result<News> getNewsByNewsId(@PathVariable int newsId) {
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsByNewsId(newsId));
    }

    @GetMapping(value = "/amount")
    public Result<Integer> getNewsAmount(String startTime, String endTime){
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsAmountByTime(startTime, endTime));
    }

    @GetMapping(value = "")
    public Result<List<News>> getNewsByUserId(int userId){
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsByUserId(userId));
    }

    @GetMapping(value = "/likeyesorno/{userId}")
    public Result<List<News>> getNewsAllByUserId(@PathVariable int userId) {
        return new Result<List<News>>(ResultEnum.SUCCESS, newsService.getNewsAllByUserIds(userId));
    }

    @GetMapping(value = "/monthAmount")
    public Result getNewsAmountAllMonth() {
        return new Result<>(ResultEnum.SUCCESS, newsService.getNewsAmountAllMonth());
    }
}
