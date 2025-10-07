package com.java.lessons.lesson06;

import java.io.*;
import java.util.*;

public class BookingService {
    private List<Seat> seats;
    private static final String FILE_PATH = "lesson06/data/seats.ser";

    public BookingService() {
        seats = loadSeats();
        if (seats == null) {
            seats = generateSeats();
        }
    }

    private List<Seat> generateSeats() {
        List<Seat> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            SeatClass seatClass = (i <= 5) ? SeatClass.BUSINESS : SeatClass.ECONOMY;
            list.add(new Seat(i, seatClass));
        }
        return list;
    }

    public void showAllSeats() {
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    public void bookSeat(int seatNumber, String fullName) {
        try {
            Seat seat = getSeat(seatNumber);
            if (seat.isBooked()) {
                System.out.println("Это место уже занято!");
                return;
            }
            seat.book(new Passenger(fullName));
            saveSeats();
            System.out.println("Место успешно забронировано!");
        } catch (Exception e) {
            System.out.println("Ошибка бронирования: " + e.getMessage());
        }
    }

    public void cancelBooking(int seatNumber) {
        try {
            Seat seat = getSeat(seatNumber);
            if (!seat.isBooked()) {
                System.out.println("Это место не было забронировано.");
                return;
            }
            seat.cancel();
            saveSeats();
            System.out.println("Бронь снята.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void showSeatInfo(int seatNumber) {
        try {
            Seat seat = getSeat(seatNumber);
            System.out.println(seat);
            if (seat.isBooked()) {
                System.out.println("Пассажир: " + seat.getPassenger());
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private Seat getSeat(int seatNumber) {
        return seats.stream()
                .filter(s -> s.getSeatNumber() == seatNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Место не найдено!"));
    }

    private void saveSeats() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(seats);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }

    private List<Seat> loadSeats() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Seat>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
    public void showPlaneLayout() {
        System.out.println("\n===== ✈️ СХЕМА САМОЛЁТА =====");

        for (Seat seat : seats) {
            String color;
            if (seat.isBooked()) {
                color = "\u001B[31m";
            } else {
                color = "\u001B[32m";
            }

            String classLabel = seat.getSeatClass() == SeatClass.BUSINESS ? "B" : "E";
            System.out.printf("%s[%s%02d]\u001B[0m ", color, classLabel, seat.getSeatNumber());

            if (seat.getSeatNumber() % 4 == 0)
                System.out.println();
        }
        System.out.println("\nЛегенда:  свободно, занято, B — бизнес, E — эконом\n");
    }
}
