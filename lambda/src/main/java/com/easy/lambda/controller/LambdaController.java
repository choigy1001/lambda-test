package com.easy.lambda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EnableWebMvc
@RestController
@RequestMapping("/drink")
public class LambdaController {

    private String getLocalDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    @GetMapping("/beer")
    public String getBeer() {
        return "We have 3L beer. " + getLocalDateTime();
    }

    @GetMapping("/whisky")
    public String getFood() {
        return "We have 3 kind of whisky. " + getLocalDateTime();
    }

    @PostMapping("/request")
    public String postBody(@RequestBody String request) {
        return "We received your request at " + getLocalDateTime() + ": " + request;
    }
}
