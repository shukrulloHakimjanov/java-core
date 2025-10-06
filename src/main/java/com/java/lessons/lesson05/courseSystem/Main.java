package com.java.lessons.lesson05.courseSystem;


public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Alice Johnson", "alice@mail.com", "Java Programming");
        Course javaCourse = new Course("Java Programming", t1);

        Student s1 = new Student("Bob", "bob@mail.com");
        Student s2 = new Student("Charlie", "charlie@mail.com");

        javaCourse.addStudent(s1);
        javaCourse.addStudent(s2);

        javaCourse.markAttendance(s1);
        javaCourse.markAttendance(s2);
        javaCourse.addGrade(s1, 85);
        javaCourse.addGrade(s2, 92);

        javaCourse.showCourseInfo();
    }
}