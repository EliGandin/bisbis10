package com.att.tdp.bisbis10.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class DemoController {


    @PostMapping(path = "/testApp")
    ResponseEntity<Boolean> testApp() {
        return ResponseEntity.ok(true);
    }

}
