package com.cdl.demo.controller;

import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("verificationCode")
public class VerificationCodeController {

    @Autowired
    private RedisService redisService;

    @PostMapping(value = "")
    public Result validateCode(String userName, Integer code) {
        Integer codeTrue = (Integer) redisService.get("verificationCode:" + userName);
        boolean flag = false;
        if (null != codeTrue) {
            flag = codeTrue.equals(code);
        }
        return new Result<>(ResultEnum.SUCCESS, flag);
    }
}
