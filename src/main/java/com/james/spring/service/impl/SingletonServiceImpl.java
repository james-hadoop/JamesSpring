package com.james.spring.service.impl;

import org.springframework.stereotype.Service;

import com.james.spring.service.IPrototypeService;

@Service("singleServiceImpl")
public class SingletonServiceImpl implements IPrototypeService {
    private String id = "SingletonServiceImpl";

    SingletonServiceImpl() {

    }

    SingletonServiceImpl(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "SingletonServiceImpl" + id;
    }
}
