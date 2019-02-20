package com.james.spring.config;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.james.spring.service.impl.EventEntity;
import com.james.spring.service.impl.MySpringApplicationEvent;
import com.james.spring.service.impl.ReturnData;

@Component
public class AnnoEventLisenterConfig {
    @EventListener
    @Async
    public void MySpringApplicationEventListener(MySpringApplicationEvent event) {
        System.out.println("MySpringApplicationEventListener triggered...");
        EventEntity entity = new EventEntity((String) event.getSource());

        ReturnData.returnData = entity.getData();
    }
}
