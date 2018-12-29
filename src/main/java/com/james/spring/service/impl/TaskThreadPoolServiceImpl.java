package com.james.spring.service.impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.james.spring.service.TaskThreadPoolService;

@Service
public class TaskThreadPoolServiceImpl implements TaskThreadPoolService {

    @Override
    @Async("myTaskAsyncPool")
    public Future<String> getTasks(int i) {
        return new AsyncResult<String>("Async task " + i);
    }
}
