package com.james.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james.spring.service.ICallSpringApplicationEventService;

@RestController
public class SpringApplicationEventController {
    @Autowired
    ICallSpringApplicationEventService service;

    @RequestMapping("/callSAES")
    String callSAES() {
        return service.callSAES();
    }
}
