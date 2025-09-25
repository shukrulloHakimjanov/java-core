package com.java.lessons.lesson02;

import java.util.Scanner;

public class Main {

    // Вывести числа от 1 до 100, каждые 10 чисел в одной строке
    public static void print1To100By10() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(" " + i);
            // После каждого 10-го числа переносим вывод на новую строку
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    //Сумма чисел от 1 до N (ввод N с клавиатуры).
    public static long sum1ToN(long n) {//  Используем long, чтобы обрабатывать очень большие числа
        // использована формула n*(n+1)/2 для вычисления суммы первых n натуральных чисел
        return n * (n + 1) / 2;
    }

    //Произведение чисел от 1 до N.
    public static long product1ToN(long n) {
        long product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }
    //Сумма цифр числа (например, 1234 → 10).
    public static long sumEven1ToN(long n) {
        long result = 0;
        for (long i = 2; i <= n; i += 2) {
            result += i;
        }
        return result;
    }

    //Разворот числа (например, 1234 → 4321).
    public static int sumDigits(long x) {
        x = Math.abs(x);
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    // Разворот числа (например, 1234 -> 4321)
    public static long reverseNumber(long x) {
        long sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        long rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev * sign;
    }

    public static long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static int firstDivisibleBy7GreaterThan1000() {
        int x = 1001; // 1001 делится на 7 (7 * 143 = 1001)
        if (x % 7 == 0) return x;
        while (x % 7 != 0) x++;
        return x;
    }

    public static void printTriangles(int rows) {
        System.out.println("Левосторонний треугольник (увеличивающийся):");
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }

        for (int i = 1; i <= rows; i++) {
            for (int s = 0; s < rows - i; s++) System.out.print(" ");
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }

        for (int i = 1; i <= rows; i++) {
            for (int s = 0; s < rows - i; s++) System.out.print(" ");
            for (int j = 0; j < 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        print1To100By10();

        System.out.println(sum1ToN(n));

        System.out.println(product1ToN(n));

        System.out.println(sumEven1ToN(n));

        System.out.println(sumDigits(n));

        System.out.println(reverseNumber(n));

        System.out.println(firstDivisibleBy7GreaterThan1000());

        printTriangles(6);
    }
}
