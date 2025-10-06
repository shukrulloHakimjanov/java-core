package com.java.lessons.lesson05.courseSystem;

class Teacher extends Person {
    private String subject;

    public Teacher(String name, String email, String subject) {
        super(name, email);
        this.subject = subject;
    }

    public String getSubject() { return subject; }

    @Override
    public void showInfo() {
        System.out.println("👨‍🏫 Teacher: " + getName() + " | Subject: " + subject);
    }
}