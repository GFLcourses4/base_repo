package com.example.base_repo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncComponent {

    @Async
    public void async() {
        System.out.println("Async run - " + Thread.currentThread().getName());
    }
}
