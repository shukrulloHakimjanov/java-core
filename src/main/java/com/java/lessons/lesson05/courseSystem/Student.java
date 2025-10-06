package com.java.lessons.lesson05.courseSystem;

import java.util.HashMap;
import java.util.Map;

class Student extends Person {
    private  Map<String, Integer> grades = new HashMap<>();
    private int attendanceDays = 0;

    public Student(String name, String email) {
        super(name, email);
    }

    public void addGrade(String course, int grade) {
        grades.put(course, grade);
    }

    public void attend() {
        attendanceDays++;
    }

    @Override
    public void showInfo() {
        System.out.println("Student: " + getName() + " | Attendance: " + attendanceDays + " days | Grades: " + grades);
    }
}