package com.example.base_repo.publisher;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestApp {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdlMainExecution = new CountDownLatch(1);
        CountDownLatch cdlToAwaitSleep = new CountDownLatch(1);

        Runnable runnable = () -> {
            System.out.println("Interrupted status on startup = " + Thread.currentThread().isInterrupted());
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Do piece of work = " + i++);
                    cdlToAwaitSleep.countDown();
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    System.out.println("Interrupt exception");
                    System.out.println("Interrupt status after exception = " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupt status after status change = " + Thread.currentThread().isInterrupted());
                }
                cdlMainExecution.countDown();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        cdlToAwaitSleep.await();
        thread.interrupt();
        cdlMainExecution.await();
        System.out.println("Application completed");
    }
}
