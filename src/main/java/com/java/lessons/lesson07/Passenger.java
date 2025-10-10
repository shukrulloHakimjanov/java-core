package com.java.lessons.lesson07;

import java.io.Serializable;

public class Passenger implements Serializable {
    private String fullName;

    public Passenger(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() { return fullName; }

    @Override
    public String toString() {
        return fullName;
    }
}
