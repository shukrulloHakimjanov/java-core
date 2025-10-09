package com.java.lessons.lesson06;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Seat implements Serializable {
    private int seatNumber;
    private SeatClass seatClass;
    private SeatStatus status;
    private Passenger passenger;
    private LocalDateTime bookingTime;

    public Seat(int seatNumber, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.status = SeatStatus.FREE;
    }

    public int getSeatNumber() { return seatNumber; }
    public SeatClass getSeatClass() { return seatClass; }
    public SeatStatus getStatus() { return status; }
    public Passenger getPassenger() { return passenger; }
    public LocalDateTime getBookingTime() { return bookingTime; }

    public boolean isBooked() {
        return status == SeatStatus.BOOKED || status == SeatStatus.PAID;
    }

    public void book(Passenger passenger) {
        this.passenger = passenger;
        this.status = SeatStatus.BOOKED;
        this.bookingTime = LocalDateTime.now();
    }

    public void pay() {
        if (status == SeatStatus.BOOKED) {
            this.status = SeatStatus.PAID;
        }
    }

    public void cancel() {
        this.passenger = null;
        this.status = SeatStatus.FREE;
        this.bookingTime = null;
    }

    @Override
    public String toString() {
        String info = String.format("Seat %d [%s] — %s", seatNumber, seatClass, status);
        if (status == SeatStatus.BOOKED && bookingTime != null) {
            info += String.format(" (booked at %s)", bookingTime);
        }
        return info;
    }
}


enum SeatClass {
    BUSINESS,
    ECONOMY
}
enum SeatStatus {
    FREE,
    BOOKED,
    PAID
}
