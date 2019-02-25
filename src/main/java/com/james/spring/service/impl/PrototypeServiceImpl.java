package com.james.spring.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.james.spring.service.IPrototypeService;

@Service("prototypeServiceImpl")
@Scope("prototype")
public class PrototypeServiceImpl implements IPrototypeService{
    private String id = "PrototypeServiceImpl";;

    PrototypeServiceImpl(String id) {
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String call() {
        return id;
    }
}
