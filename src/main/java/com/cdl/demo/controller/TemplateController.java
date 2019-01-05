package com.cdl.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

    @RequestMapping(value = "/")
    public String getIndex() {
        return "index";
    }
}
