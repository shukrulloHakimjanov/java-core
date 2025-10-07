package com.java.lessons.lesson06;

import java.io.Serializable;

public class Seat implements Serializable {
    private int seatNumber;
    private SeatClass seatClass;
    private boolean isBooked;
    private Passenger passenger;

    public Seat(int seatNumber, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isBooked = false;
    }

    public int getSeatNumber() { return seatNumber; }
    public SeatClass getSeatClass() { return seatClass; }
    public boolean isBooked() { return isBooked; }
    public Passenger getPassenger() { return passenger; }

    public void book(Passenger passenger) {
        this.passenger = passenger;
        this.isBooked = true;
    }

    public void cancel() {
        this.passenger = null;
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return String.format("Место %d [%s] — %s",
                seatNumber, seatClass,
                isBooked ? "ЗАНЯТО" : "СВОБОДНО");
    }
}

enum SeatClass {
    BUSINESS,
    ECONOMY
}
