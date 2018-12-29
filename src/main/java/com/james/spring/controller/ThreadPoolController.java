package com.james.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james.spring.service.TaskThreadPoolService;

@RestController
public class ThreadPoolController {
    @Autowired
    TaskThreadPoolService taskThreadPoolService;

    @RequestMapping("/threadCall")
    List<String> threadCall() throws InterruptedException, ExecutionException {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            Future<String> future = taskThreadPoolService.getTasks(i);

            list.add(future.get());
        }

        return list;
    }
}
