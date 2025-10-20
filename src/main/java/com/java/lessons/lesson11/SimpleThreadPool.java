package com.java.lessons.lesson11;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] workerThreads;
    private boolean isShutdown;

    public SimpleThreadPool(int poolSize) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workerThreads = new Thread[poolSize];
        this.isShutdown =false;

        initializeWorkers(poolSize);
    }

    private void initializeWorkers(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            workerThreads[i] = new Thread(new Worker(), "Pool-Worker-" + (i + 1));
            workerThreads[i].start();
        }
    }

    public void submit(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("ThreadPool is shutdown");
        }

        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        isShutdown=(true);

        for (Thread worker : workerThreads) {
            worker.interrupt();
        }
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (!isShutdown || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        SimpleThreadPool pool = new SimpleThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.printf("Task %d executed by %s%n",
                        taskId, Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }
            });
        }

        Thread.sleep(5000);

        pool.shutdown();
        System.out.println("Pool shutdown completed");
    }
}