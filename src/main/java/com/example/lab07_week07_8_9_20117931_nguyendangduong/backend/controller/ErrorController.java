package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("/notLogin")
    public String errorNotLogin(){
        return "errorLogin";
    }
}
