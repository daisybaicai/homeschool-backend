package com.cdl.demo.controller;

import com.cdl.demo.domain.MyClass;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.MyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class MyClassController {

    @Autowired
    private MyClassService myClassService;

    @GetMapping(value = "/{classId}")
    Result queryClassById(@PathVariable int classId) {
        return new Result<>(ResultEnum.SUCCESS, myClassService.queryClassById(classId));
    }
}
