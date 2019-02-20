package com.james.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.james.spring.service.ICallSpringApplicationEventService;

@Service
public class CallSpringApplicationEventServiceImpl implements ICallSpringApplicationEventService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String callSAES() {
        System.out.println("start callSAES()...");

        applicationEventPublisher.publishEvent(new MySpringApplicationEvent(new String("I am callSAES()!")));

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stop  callSAES()...");

        return ReturnData.returnData;
    }
}
