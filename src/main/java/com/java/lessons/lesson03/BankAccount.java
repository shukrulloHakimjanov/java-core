package com.java.lessons.lesson03;

public class BankAccount {
    String fio;
    String accountNumber;
    double balance;

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнение: +" + amount + " | Баланс: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Снятие: -" + amount + " | Баланс: " + balance);
        } else {
            System.out.println("Недостаточно средств!");
        }
    }

    public double getBalance() {
        return balance;
    }
}
