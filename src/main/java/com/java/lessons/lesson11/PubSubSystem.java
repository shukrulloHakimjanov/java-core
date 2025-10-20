package com.java.lessons.lesson11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class PubSubSystem {
    private final BlockingQueue<String> messageQueue;
    private boolean running;
    private final Thread subscriberThread;

    public PubSubSystem() {
        this.messageQueue = new LinkedBlockingQueue<>();
        this.running = true;
        
        this.subscriberThread = new Thread(this::subscriberWorker, "Subscriber-Thread");
        this.subscriberThread.start();
    }

    public void publish(String message) {
        if (running) {
            try {
                messageQueue.put(message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void subscriberWorker() {
        while (running || !messageQueue.isEmpty()) {
            try {
                String message = messageQueue.take();
                if ("exit".equalsIgnoreCase(message)) {
                    shutdown();
                    break;
                }
                System.out.println("Subscriber received: " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void shutdown() {
        running=false;
        subscriberThread.interrupt();
    }

    public static void main(String[] args) {
        PubSubSystem pubSub = new PubSubSystem();
        
        System.out.println("Pub/Sub System started. Type 'exit' to quit.");
        
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();
                pubSub.publish(input);
                
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
            }
        }
        
        pubSub.shutdown();
        System.out.println("Pub/Sub System stopped.");
    }
}