package com.cdl.demo.controller;

import com.cdl.demo.domain.Accusation;
import com.cdl.demo.domain.Result;
import com.cdl.demo.enums.ResultEnum;
import com.cdl.demo.service.AccuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accuse")
public class AccuseController {

    @Autowired
    private AccuseService accuseService;

    @PostMapping(value = "addAccuse")
    public Result addAccuse(Accusation accusation) {
        return new Result<>(0, "chengong",accuseService.addAccuse(accusation));
    }

    @GetMapping(value = "getAccusationByPage")
    public Result getAccusationByPage(int pageNumber, int pageSize) {
        return new Result<>(ResultEnum.SUCCESS, accuseService.queryAccusationByPage(pageNumber, pageSize));
    }

    @PutMapping(value = "updateAccusationStatus")
    public Result updateAccusationStatus(int accusationId, int accusationStatus) {
        return new Result<>(ResultEnum.SUCCESS, accuseService.updateAccusationStatus(accusationId, accusationStatus));
    }
}
