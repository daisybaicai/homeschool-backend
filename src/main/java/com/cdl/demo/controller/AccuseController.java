package com.cdl.demo.controller;

import com.cdl.demo.domain.Accusation;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.AccuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accuse")
public class AccuseController {

    @Autowired
    private AccuseService accuseService;
    @PostMapping(value = "addAccuse")
    public Result addAccuse(Accusation accusation) {
        System.out.println(accusation);
        return new Result(0, "chengong",accuseService.addAccuse(accusation));
    }
}
