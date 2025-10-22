package com.java.lessons.lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.*;

public class FunctionalTasks {
    public static void main(String[] args) {
        List<String> stringList = List.of("one", "two", "three", "four", "five");


        /**
         * Создай Predicate<String>, который проверяет, что строка не пуста и длиннее 3 символов.
         * **/
        Predicate<String> nonEmptyAndLongerThan3 = s -> s != null && !s.isEmpty() && s.length() > 3;
        System.out.println("Checking 1st task : hello: " + nonEmptyAndLongerThan3.test("hello"));
        System.out.println("Checking 1st task : hi: " + nonEmptyAndLongerThan3.test("hi"));

        /**
         * Создай Function<String, Integer>, возвращающую длину строки.
         */
        Function<String, Integer> getLength = String::length;
        System.out.println("Checking 2nd task : " + getLength.apply("hello"));

        /**
         * Создай Supplier<UUID>, который возвращает новый UUID при каждом вызове.
         */
        Supplier<UUID> uuid = UUID::randomUUID;
        System.out.println("Checking 3rd task : " + uuid.get());

        /**
         * Создай Consumer<String>, который выводит строку в upper case.
         */
        Consumer<String> upperCasePrinter = s -> System.out.println(s.toUpperCase());
        System.out.print("Checking 4th task :  ");
        upperCasePrinter.accept("hello world");

        /**
         * Создай BiFunction<Integer, Integer, Integer>, которая возвращает сумму двух чисел
         */
        BiFunction<Integer, Integer, Integer> sumOfTwo = Integer::sum;
        System.out.println("Checking 5th task : " + sumOfTwo.apply(1, 2));

        /**
         * Function<String, String> trim и Function<String, String> toUpperCase. Объедини их в одну, которая сначала обрезает пробелы, потом делает верхний регистр.
         */
        Function<String, String> trim = String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> trimAndUpperCase = trim.andThen(toUpperCase);
        System.out.println("Checking 6th task : '" + trimAndUpperCase.apply("  hello  ") + "'");
        /**
         * Один Consumer печатает строку в консоль, второй — печатает длину строки. Объедини их через andThen().
         */
        Consumer<String> printString = System.out::print;
        Consumer<String> printLength = s -> System.out.println("   Length: " + s.length());
        Consumer<String> combinedConsumer = printString.andThen(printLength);
        System.out.print("Cheching 7th task : ");
        combinedConsumer.accept("Test String");

        /**
         * Создай Predicate<Integer> isEven и isPositive. Получи Predicate, который проверяет "нечётное или отрицательное".
         */
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isPositieAndEven = isPositive.and(isEven);
        System.out.println("Checking 8th task : " + isPositieAndEven.test(2));

        /**
         * BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b; Function<Integer, String> toStr = x -> "Result: " + x; Используй andThen(), чтобы объединить в одну цепочку.
         */
        BiFunction<Integer, Integer, Integer> addTwo = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        BiFunction<Integer, Integer, String> multiplyAndConvert = addTwo.andThen(toStr);
        System.out.println("Checking 9th task " + multiplyAndConvert.apply(4, 5));

        /**
         * Создай UnaryOperator<String>, который добавляет "!!!" к строке.
         */
        UnaryOperator<String> addSign = x -> x + "!!!";
        System.out.println("Checking 10th task : " + addSign.apply("Hello"));

        /**
         * Создай метод filter(List<T> list, Predicate<T> predicate), который вручную фильтрует коллекцию аналогично Stream API
         */
        List<String> filtered = filter(stringList, s -> s.length() > 3);
        System.out.println("Checking 11th task : " + filtered);

        /**
         * Создай метод map(List<T> list, Function<T, R> mapper) и преобразуй List<String> в List<Integer> (длины строк).
         */
        List<Integer> lengths = map(stringList, String::length);
        System.out.println("Checking lengths of string " + lengths);
        /**
         * Создай метод forEach(List<T> list, Consumer<T> consumer) и напечатай каждый элемент списка.
         */
        System.out.print("Checking 13th task : ");
        forEach(stringList, System.out::println);

        /**
         * Напиши метод generate(Supplier<T> supplier, int n), который создаёт список из n элементов, полученных от supplier.
         */
        List<Double> randomNumbers = generate(Math::random, 5);
        System.out.println("Checking 14th task: " + randomNumbers);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T item : list) {
            consumer.accept(item);
        }
    }

    // 14. Метод generate
    public static <T> List<T> generate(Supplier<T> supplier, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(supplier.get());
        }
        return result;
    }
}
