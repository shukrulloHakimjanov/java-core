package com.java.lessons.lesson02;

import java.util.Scanner;

public class Tasks {

    // Вывести числа от 1 до 100, каждые 10 чисел в одной строке
    public static void print1To100By10() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(" " + i);
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    // Сумма чисел от 1 до N
    public static long sum1ToN(long n) {
        return n * (n + 1) / 2;
    }

    // Произведение чисел от 1 до N
    public static long product1ToN(long n) {
        long product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    // Сумма всех чётных чисел от 1 до N
    public static long sumEven1ToN(long n) {
        long result = 0;
        for (long i = 2; i <= n; i += 2) {
            result += i;
        }
        return result;
    }

    // Сумма цифр числа
    public static int sumDigits(long x) {
        x = Math.abs(x);
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    // Разворот числа
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

    // Факториал числа
    public static long factorial(long n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    // Первое число, которое делится на 7 и больше 1000
    public static int firstDivisibleBy7GreaterThan1000() {
        int x = 1001;
        while (x % 7 != 0) x++;
        return x;
    }

    // Простые числа до N
    public static void primesUpToN(long n) {
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Треугольники из звёздочек
    public static void printTriangles(int rows) {
        // Прямой
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }

        // Прямой с выравниванием вправо
        for (int i = 1; i <= rows; i++) {
            for (int s = 0; s < rows - i; s++) System.out.print(" ");
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }

        // Равнобедренный
        for (int i = 1; i <= rows; i++) {
            for (int s = 0; s < rows - i; s++) System.out.print(" ");
            for (int j = 0; j < 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println("\n--- Числа от 1 до 100 ---");
        print1To100By10();

        System.out.println("\n--- Сумма от 1 до N ---");
        System.out.println(sum1ToN(n));

        System.out.println("\n--- Произведение от 1 до N ---");
        System.out.println(product1ToN(n));

        System.out.println("\n--- Сумма чётных от 1 до N ---");
        System.out.println(sumEven1ToN(n));

        System.out.println("\n--- Сумма цифр числа ---");
        System.out.println(sumDigits(n));

        System.out.println("\n--- Факториал числа ---");
        System.out.println(factorial(n));

        System.out.println("\n--- Разворот числа ---");
        System.out.println(reverseNumber(n));

        System.out.println("\n--- Первое число >1000, делящееся на 7 ---");
        System.out.println(firstDivisibleBy7GreaterThan1000());

        System.out.println("\n--- Простые числа до 20 ---");
        primesUpToN(n);

        System.out.println("\n--- Треугольники из * ---");
        printTriangles(6);
    }
}
