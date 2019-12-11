package com.hongjun.redisStudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class HomeController {
    @GetMapping("/hello")
    public String home(HttpSession httpSession) {
        return httpSession.getId();
    }
}
