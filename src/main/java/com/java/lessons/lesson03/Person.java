package com.java.lessons.lesson03;


import lombok.Data;

@Data
public class Person {
    String name;
    int age;

    public void introduce() {
        System.out.println("Привет! Меня зовут " + name + ", мне " + age + " лет.");
    }


}
