package com.java.lessons.lesson03;
import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    String accountNumber;
    String fio;
    double balance;

    static List<BankSystem> accounts = new ArrayList<>();

    public void getAccountInfo() {
        System.out.println(accountNumber + " | " + fio + " | Баланс: " + balance);
    }

    public static void addAccount(BankSystem account) {
        accounts.add(account);
        System.out.println("Счёт добавлен: " + account.fio);
    }

    public static void deleteAccount(String accountNumber) {
        accounts.removeIf(acc -> acc.accountNumber.equals(accountNumber));
        System.out.println("Счёт " + accountNumber + " удалён.");
    }

    public void replenishAccount(double amount) {
        balance += amount;
        System.out.println("Пополнение: +" + amount + " | Баланс: " + balance);
    }

    public static void transferMoneyBetweenAccounts(BankSystem from, BankSystem to, double amount) {
        if (from.balance >= amount) {
            from.balance -= amount;
            to.balance += amount;
            System.out.println("Перевод " + amount + " от " + from.fio + " к " + to.fio);
        } else {
            System.out.println("Недостаточно средств для перевода!");
        }
    }
}

