package com.cdl.demo.controller;

import com.cdl.demo.domain.PersonalInformation;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/personal1")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;

    @GetMapping(value = "/Personalinform/{userId}")
    public Result getPersonalInformByUserId(@PathVariable int userId) {
        PersonalInformation personalInformation=personalInformationService.getInformationByUserId(userId);
        return new Result<>(ResultEnum.SUCCESS, personalInformation);
    }

    @PutMapping(value = "/changeJianjie")
    public Result changejianjie(Integer userId, String value) {
        System.out.println(userId + value);
            return new Result<>(0,"修改成功",personalInformationService.changeJianjie(userId,value));
    }

    @PutMapping(value = "/changeAddress")
    public Result changeAddress(Integer userId, String value) {
        System.out.println(userId + value);
        return new Result<>(0,"修改成功",personalInformationService.changeAddress(userId,value));
    }

    @PutMapping(value = "/changePhone")
    public Result changePhone(Integer userId, String value) {
        System.out.println(userId + value);
        return new Result<>(0,"修改成功",personalInformationService.changePhone(userId,value));
    }

    @PutMapping(value = "/changeInterest")
    public Result changeInterest(Integer userId, String value) {
        System.out.println(userId + value);
        return new Result<>(0,"修改成功",personalInformationService.changeInterest(userId,value));
    }

    @PutMapping(value = "/changeWork")
    public Result changeWork(Integer userId, String value) {
        System.out.println(userId + value);
        return new Result<>(0,"修改成功",personalInformationService.changeWork(userId,value));
    }
}
