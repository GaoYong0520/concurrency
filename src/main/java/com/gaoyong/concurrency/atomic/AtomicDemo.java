package com.gaoyong.concurrency.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static AtomicInteger count = new AtomicInteger(0);
    public static int clientTotal = 500;
    public static int threadTotal = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    }

    public static void add() {

    }


}
