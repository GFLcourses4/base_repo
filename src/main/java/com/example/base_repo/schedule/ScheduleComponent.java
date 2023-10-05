package com.example.base_repo.schedule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleComponent {
    private int taskNumber = 0;
    @Value(value = "#{testBla.arg}")
    private int arg;
    @Value(value = "#{testBla.type}")
    private String type;

//    @Async
//    @Scheduled(fixedRateString = "#{testBla.arg}")
    public void scheduleTask() throws InterruptedException {
        System.out.println("ARG - " + arg);
        System.out.println("type - " + type);
        System.out.println(String.format("Task %s, run at %s, thread name %s", taskNumber, System.currentTimeMillis(), Thread.currentThread().getName()));
        taskNumber++;
        Thread.sleep(3000);
    }
}
