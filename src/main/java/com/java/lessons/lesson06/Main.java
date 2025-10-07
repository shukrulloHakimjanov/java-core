package com.java.lessons.lesson06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookingService service = new BookingService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== ✈️ СИСТЕМА БРОНИРОВАНИЯ ✈️ =====");
            System.out.println("1. Показать все места (списком)");
            System.out.println("2. Показать схему самолёта");
            System.out.println("3. Забронировать место");
            System.out.println("4. Снять бронь");
            System.out.println("5. Информация о месте");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> service.showAllSeats();
                case 2 -> service.showPlaneLayout(); // ✅ new airplane layout
                case 3 -> {
                    System.out.print("Введите номер места: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Введите ФИО пассажира: ");
                    String name = sc.nextLine();
                    service.bookSeat(num, name);
                }
                case 4 -> {
                    System.out.print("Введите номер места: ");
                    int num = sc.nextInt();
                    service.cancelBooking(num);
                }
                case 5 -> {
                    System.out.print("Введите номер места: ");
                    int num = sc.nextInt();
                    service.showSeatInfo(num);
                }
                case 0 -> {
                    System.out.println("👋 Программа завершена.");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }
}
