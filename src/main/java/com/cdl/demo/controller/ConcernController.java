package com.cdl.demo.controller;

import com.cdl.demo.domain.Concern;
import com.cdl.demo.domain.Result;
import com.cdl.demo.domain.User;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.ConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/concern")
public class ConcernController {

    @Autowired
    private ConcernService concernService;

    @GetMapping(value = "/getStarConcern/{userId}")
    public Result<List<Concern>> getStarConcern(@PathVariable int userId) {
        List<Concern> users=concernService.getUserStarConcern(userId);
        return new Result<List<Concern>>(ResultEnum.SUCCESS, users);
    }

    @GetMapping(value = "/getAllConcern/{userId}")
    public Result<List<Concern>> getAllConcern(@PathVariable int userId) {
        List<Concern> users=concernService.getUserAllConcern(userId);
        return new Result<List<Concern>>(ResultEnum.SUCCESS, users);
    }

    @GetMapping(value = "/getAlluser/{userId}")
    public Result<List<Concern>> getAlluser(@PathVariable int userId) {
        List<User> users=concernService.getAllUser(userId);
        List<Concern> concerns = new ArrayList<>();
        for (User u:users){
            Concern c = new Concern();
            c.setStarConcern("0");
            c.setUser1(u);
            concerns.add(c);
        }
        return new Result<List<Concern>>(ResultEnum.SUCCESS, concerns);
    }

    @PutMapping(value = "/removeConcernsStar")
    public Result removeConcernsStar(Integer userId, Integer value) {
        return new Result<>(0,"修改成功",concernService.removeConcernsStar(userId,value));
    }

    @PutMapping(value = "/sendConcernStar")
    public Result sendConcernStar(Integer userId, Integer value) {
        return new Result<>(0,"修改成功",concernService.sendConcernStar(userId,value));
    }

    @PutMapping(value = "/deleteConcern")
    public Result deleteConcern(Integer userId, Integer value) {
        return new Result<>(0,"修改成功",concernService.deleteConcern(userId,value));
    }

    @PutMapping(value = "/sendConcern")
    public Result sendConcern(Integer userId, Integer value) {
        return new Result<>(0,"成功",concernService.sendConcern(userId,value));
    }
}
