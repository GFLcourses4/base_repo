package com.example.base_repo.executors;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutorsTest {

    @Test
    public void cachedThreadPullTest() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        assertEquals(3, executorService.getPoolSize());
        assertEquals(0, executorService.getQueue().size());
    }

    @Test
    public void FixedThreadPullTest() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        assertEquals(2, executorService.getPoolSize());
        assertEquals(1, executorService.getQueue().size());
    }

    @Test
    public void scheduleThreadPullTest() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture<String> schedule = scheduledExecutorService.schedule(() -> "Schedule Thread -> " + Thread.currentThread().getName(),
                3, TimeUnit.SECONDS);
        String s = schedule.get();
        System.out.println("Main Thread");
        System.out.println(s);
    }

    @Test
    public void scheduleRateThreadPullTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService
                .scheduleAtFixedRate(() -> {
                            System.out.println("Test");
                            countDownLatch.countDown();
                        },
                        3, 1, TimeUnit.SECONDS);
        countDownLatch.await();
        System.out.println("Main Thread");
        scheduledFuture.cancel(true);
    }
}
