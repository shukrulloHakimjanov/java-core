package com.java.lessons.lesson02;

import java.util.*;

public class Subtasks {

    // Обмен значений
    public static void swapNumbers(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + ", b = " + b);
    }

    // Таблица умножения
    public static void multiplicationTable() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    // Конвертер валют
    public static void currencyConverter(double dollars) {
        double exchange = 12500;
        System.out.println("В сумах: " + (dollars * exchange));
    }

    // Четное или нечетное
    public static void evenOdd(int n) {
        System.out.println(n % 2 == 0 ? "Четное" : "Нечетное");
    }

    // Максимум из трёх
    public static void maxOfThree(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        System.out.println("Максимум: " + max);
    }

    // Калькулятор
    public static void calculator(double a, double b, char op) {
        switch (op) {
            case '+' -> System.out.println(a + b);
            case '-' -> System.out.println(a - b);
            case '*' -> System.out.println(a * b);
            case '/' -> System.out.println(b != 0 ? a / b : "Ошибка: деление на ноль");
            default -> System.out.println("Неизвестная операция");
        }
    }

    // Среднее арифметическое
    public static void average(int[] arr) {
        double sum = 0;
        for (int x : arr) sum += x;
        System.out.println("Среднее: " + (sum / arr.length));
    }

    // Поиск элемента
    public static void searchElement(int[] arr, int x) {
        boolean found = false;
        for (int num : arr) {
            if (num == x) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "Есть" : "Нет");
    }

    // Мини-игра "Угадай число"
    public static void guessNumber() {
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        int attempts = 5;
        Scanner sc = new Scanner(System.in);

        System.out.println("Угадай число от 1 до 100. У тебя " + attempts + " попыток.");

        while (attempts > 0) {
            int guess = sc.nextInt();
            if (guess == number) {
                System.out.println("Поздравляю, ты угадал!");
                return;
            } else if (guess < number) {
                System.out.println("Загаданное число больше.");
            } else {
                System.out.println("Загаданное число меньше.");
            }
            attempts--;
        }
        System.out.println("Ты проиграл. Загаданное число: " + number);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число (a): ");
        int a = sc.nextInt();

        System.out.print("Введите второе число (b): ");
        int b = sc.nextInt();

        System.out.print("Введите число n (для проверки четности, max и др.): ");
        int n = sc.nextInt();

        System.out.print("Введите сумму в долларах: ");
        double x = sc.nextDouble();

        System.out.print("Введите операцию (+, -, *, /): ");
        char op = sc.next().charAt(0);

        // Массив для среднего арифметического
        System.out.print("Введите размер массива для среднего арифметического: ");
        int size1 = sc.nextInt();
        int[] arr1 = new int[size1];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Массив для поиска элемента
        System.out.print("Введите размер массива для поиска: ");
        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.print("Введите число для поиска: ");
        int searchNum = sc.nextInt();

        // --- Вызовы методов ---
        System.out.println("\n--- Обмен значений ---");
        swapNumbers(a, b);

        System.out.println("\n--- Таблица умножения ---");
        multiplicationTable();

        System.out.println("\n--- Конвертер валют ---");
        currencyConverter(x);

        System.out.println("\n--- Четное или нечетное ---");
        evenOdd(n);

        System.out.println("\n--- Максимум из трех ---");
        maxOfThree(a, b, n);

        System.out.println("\n--- Калькулятор ---");
        calculator(a, b, op);

        System.out.println("\n--- Среднее арифметическое ---");
        average(arr1);

        System.out.println("\n--- Поиск элемента ---");
        searchElement(arr2, searchNum);

        System.out.println("\n--- Мини-игра 'Угадай число' ---");
        guessNumber();
    }
}