package com.techacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DailyController {
    @GetMapping("/")
    public String getIndex() {
        // index.htmlに画面遷移
        return "dailyreportsystem/dailyreportsystem";
    }
}
