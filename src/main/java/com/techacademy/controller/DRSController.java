package com.techacademy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DRSController {

    @GetMapping("/")
    public String getIndex() {

        return "dailyreportsystem/dailyreportsystem";
    }

}


