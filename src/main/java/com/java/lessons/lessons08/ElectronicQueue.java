package com.java.lessons.lessons08;

import java.util.LinkedList;
import java.util.Queue;

public class ElectronicQueue {
    private Queue<User> queue;

    public ElectronicQueue() {
        this.queue = new LinkedList<>();
    }

    public void addUser(String name) {
        User user = new User(name);
        queue.add(user);
        System.out.println("Added: " + user + ". People in queue: " + queue.size());
    }

    public void processUser() {
        User user = queue.poll();
        if (user != null) {
            System.out.println("Processed: " + user + ". People remaining in queue: " + queue.size());
        } else {
            System.out.println("Queue is empty!");
        }
    }

    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Current queue:");
            for (User user : queue) {
                System.out.println("  " + user);
            }
        }
    }

    public static void main(String[] args) {
        ElectronicQueue eq = new ElectronicQueue();

        eq.addUser("John Smith");
        eq.addUser("Maria Johnson");
        eq.addUser("Alex Brown");

        eq.showQueue();

        eq.processUser();
        eq.processUser();

        eq.addUser("Olga Davis");

        eq.showQueue();

        eq.processUser();
        eq.processUser();
    }
}