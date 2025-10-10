package com.java.lessons.lesson06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookingService service = new BookingService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== AIRPLANE BOOKING SYSTEM =====");
            System.out.println("1. Show all seats (list view)");
            System.out.println("2. Show airplane layout");
            System.out.println("3. Book a seat");
            System.out.println("4. Cancel a booking");
            System.out.println("5. Show seat information");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.showAllSeats();
                case 2 -> service.showPlaneLayout();
                case 3 -> {
                    System.out.print("Enter seat number: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter passenger full name: ");
                    String name = sc.nextLine();
                    service.bookSeat(num, name);
                }
                case 4 -> {
                    System.out.print("Enter seat number: ");
                    int num = sc.nextInt();
                    service.cancelBooking(num);
                }
                case 5 -> {
                    System.out.print("Enter seat number: ");
                    int num = sc.nextInt();
                    service.showSeatInfo(num);
                }
                case 0 -> {
                    System.out.println("Program finished. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
