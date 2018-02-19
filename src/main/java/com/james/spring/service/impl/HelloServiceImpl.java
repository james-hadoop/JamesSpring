package com.james.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.spring.dao.mapper.TEventPageMapper;
import com.james.spring.entity.TEventPage;
import com.james.spring.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    TEventPageMapper tEventPageMapper;

    @Override
    public List<TEventPage> getAll() {
        return tEventPageMapper.getAll();
    }

}
