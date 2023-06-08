package com.example.base_repo.worker;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Worker {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch mainCDL = new CountDownLatch(1);
        CountDownLatch awaitCDL = new CountDownLatch(3);
        Runnable runnable = () -> {
            System.out.println("Interrupted status on startup = " + Thread.currentThread().isInterrupted());
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Count of scenario = " + i++);
                    awaitCDL.countDown();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    System.out.println("Is Interrupted thread - " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("Is Interrupted thread - " + Thread.currentThread().isInterrupted());
                }
            }
            mainCDL.countDown();
        };

        Thread thread = new Thread(runnable);
        thread.start();

        awaitCDL.await();

        thread.interrupt();

        mainCDL.await();

        System.out.println("Application completed.");

    }
}
