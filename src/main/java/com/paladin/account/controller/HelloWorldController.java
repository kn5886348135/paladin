package com.paladin.account.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/25 21:06
 */
@RestController
@RequestMapping("/test")
public class HelloWorldController {

    @GetMapping(value = "/hello", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String helloWorld(String str) {
        return "hello world" + str;
    }

    @GetMapping(value = "/world", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes =
            {MediaType.APPLICATION_JSON_VALUE})
    public String test() {
        return "hello world";
    }
}
