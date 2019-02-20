package com.james.spring.service.impl;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

public class EventEntity {
    private String data;

    public EventEntity(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Lookup
    public CallSpringApplicationEventServiceImpl createService() {
        return null;
    }

    @EventListener
    @Async
    public void MySpringApplicationEventListener(MySpringApplicationEvent event) {
        System.out.println("MySpringApplicationEventListener triggered...");
        EventEntity entity = new EventEntity((String) event.getSource());

        ReturnData.returnData = entity.getData();
    }
}
