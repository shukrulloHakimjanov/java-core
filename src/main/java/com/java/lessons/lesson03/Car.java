package com.java.lessons.lesson03;

public class Car {
    String country;
    String model;
    int yearOfManufacture;

    public void printCarInfo() {
        System.out.println("Автомобиль: " + model + " (" + country + "), год выпуска: " + yearOfManufacture);
    }
}
