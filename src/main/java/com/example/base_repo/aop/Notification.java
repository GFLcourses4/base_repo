package com.example.base_repo.aop;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class Notification {
    public void aopNotificationExample(String message) throws Exception {
        throw new Exception("Test Message");
//        TimeUnit.SECONDS.sleep(2);
    }
}
