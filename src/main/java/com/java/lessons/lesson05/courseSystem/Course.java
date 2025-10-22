package com.java.lessons.lesson05.courseSystem;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    public Course(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void markAttendance(Student s) {
        s.attend();
    }

    public void addGrade(Student s, int grade) {
        s.addGrade(title, grade);
    }

    public void showCourseInfo() {
        System.out.println("\nCourse: " + title);
        teacher.showInfo();
        System.out.println("Students:");
        for (Student s : students) {
            s.showInfo();
        }
    }
}