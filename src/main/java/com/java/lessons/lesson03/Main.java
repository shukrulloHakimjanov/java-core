package com.java.lessons.lesson03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Person");
            System.out.println("2. Rectangle");
            System.out.println("3. Car");
            System.out.println("4. BankAccount");
            System.out.println("5. Book");
            System.out.println("6. OnlineStore");
            System.out.println("7. BankSystem");
            System.out.println("8. Street Fighter Game");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");
            int choice = sc.nextInt();
            sc.nextLine(); // очищаем буфер

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите имя: ");
                    String name = sc.nextLine();
                    System.out.print("Введите возраст: ");
                    int age = sc.nextInt();
                    Person p = new Person();
                    p.name = name;
                    p.age = age;
                    p.introduce();
                }
                case 2 -> {
                    System.out.print("Введите длину: ");
                    double length = sc.nextDouble();
                    System.out.print("Введите ширину: ");
                    double width = sc.nextDouble();
                    Rectangle r = new Rectangle();
                    r.length = length;
                    r.width = width;
                    System.out.println("Площадь = " + r.calculateSquare());
                    System.out.println("Периметр = " + r.calculatePerimeter());
                }
                case 3 -> {
                    Car car = new Car();
                    System.out.print("Страна: ");
                    car.country = sc.nextLine();
                    System.out.print("Модель: ");
                    car.model = sc.nextLine();
                    System.out.print("Год выпуска: ");
                    car.yearOfManufacture = sc.nextInt();
                    car.printCarInfo();
                }
                case 4 -> {
                    BankAccount acc = new BankAccount();
                    System.out.print("ФИО: ");
                    acc.fio = sc.nextLine();
                    System.out.print("Номер счёта: ");
                    acc.accountNumber = sc.nextLine();
                    acc.balance = 0;
                    acc.deposit(1000);
                    acc.withdraw(200);
                    System.out.println("Баланс: " + acc.getBalance());
                }
                case 5 -> {
                    Book b = new Book();
                    System.out.print("ISBN: ");
                    b.isbn = sc.nextLine();
                    System.out.print("Название: ");
                    b.name = sc.nextLine();
                    System.out.print("Автор: ");
                    b.author = sc.nextLine();
                    System.out.print("Год: ");
                    b.year = sc.nextInt();
                    sc.nextLine();
                    b.status = "доступна";
                    Book.addNewBook(b);
                    b.getBookInfo();
                    b.reserveBook();
                }
                case 6 -> {
                    OnlineStore p = new OnlineStore();
                    System.out.print("Код товара: ");
                    p.code = sc.nextLine();
                    System.out.print("Название: ");
                    p.name = sc.nextLine();
                    System.out.print("Цена: ");
                    p.price = sc.nextDouble();
                    System.out.print("Количество: ");
                    p.count = sc.nextInt();
                    OnlineStore.addProduct(p);
                    p.getProductInfo();
                    p.buyProduct(1);
                }
                case 7 -> {
                    BankSystem a1 = new BankSystem();
                    a1.accountNumber = "111";
                    a1.fio = "Иванов Иван";
                    a1.balance = 500;

                    BankSystem a2 = new BankSystem();
                    a2.accountNumber = "222";
                    a2.fio = "Петров Петр";
                    a2.balance = 300;

                    BankSystem.addAccount(a1);
                    BankSystem.addAccount(a2);

                    a1.getAccountInfo();
                    a2.getAccountInfo();

                    BankSystem.transferMoneyBetweenAccounts(a1, a2, 200);
                }
                case 8 -> {
                    Fighter f1 = new Fighter();
                    f1.code = 1;
                    f1.name = "Ryu";
                    f1.health = 100;
                    f1.attack = 20;

                    Fighter f2 = new Fighter();
                    f2.code = 2;
                    f2.name = "Ken";
                    f2.health = 100;
                    f2.attack = 18;

                    f1.getFighterInfo();
                    f2.getFighterInfo();
                    f1.fight(f2);
                }
                case 0 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }
}

