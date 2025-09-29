package com.java.lessons.lesson03;

import lombok.Data;

@Data
public class Rectangle {
    double length;
    double width;

    public double calculateSquare() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
