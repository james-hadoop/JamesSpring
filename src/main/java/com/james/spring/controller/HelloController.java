package com.james.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james.spring.entity.TEventPage;
import com.james.spring.service.HelloService;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    String hello() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/test")
    List<TEventPage> test() {
        return helloService.getAll();
    }
}