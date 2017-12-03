package com.james.spring.service.impl;

import org.springframework.stereotype.Service;

@Service
public class StaticResourceAuthenticationServiceImpl {
    public boolean isPass(boolean result) {
        System.out.println("StaticResourceAuthenticationServiceImpl.isPass() result="+result);
        return result;
    }
}