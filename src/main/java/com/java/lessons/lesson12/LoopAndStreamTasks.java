package com.java.lessons.lesson12;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Setter
@Getter
public class LoopAndStreamTasks {
    /**
     * Дан список чисел. Оставь только чётные и выведи их квадраты.
     * List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
     *
     * @param squares
     */
    public static void evenIntInSquares(List<Integer> squares) {
        List<Integer> resultFromLoop = new ArrayList<>();
        for (int square : squares) {
            if (square % 2 == 0) {
                resultFromLoop.add(square * square);
            }
        }
        System.out.println("(Output from loops) Squares are: " + resultFromLoop);

        List<Integer> resultFromStream = squares.stream().filter(m -> m % 2 == 0).map(m -> m * m).toList();
        System.out.println("(Output from stream) Squares are: " + resultFromStream);
    }

    /**
     * *Подсчитай, сколько строк в списке длиннее 5 символов.
     * List<String> words = List.of("apple", "banana", "pear", "pineapple");
     */
    public static void countLongStrings(List<String> strings) {
        List<String> resultFromLoop = new ArrayList<>();
        for (String string : strings) {
            if (string.length() == 5) {
                resultFromLoop.add(string);
            }
        }
        System.out.println("(Output from loops) Count String are: " + resultFromLoop);

        List<String> resultFromStream = strings.stream().filter(string -> string.length() == 5).toList();
        System.out.println("(Output from stream) Count String are: " + resultFromStream);
    }

    /**
     * Найди максимальное и минимальное число в списке с помощью Stream API.
     **/
    public static void maxAndMinNums(List<Integer> nums) {
        int min3For = Integer.MAX_VALUE;
        int max3For = Integer.MIN_VALUE;
        for (Integer num : nums) {
            if (num < min3For) min3For = num;
            if (num > max3For) max3For = num;
        }
        System.out.println("(Output loop) Min/Max : " + min3For + "/" + max3For);

        Optional<Integer> min3Stream = nums.stream().min(Integer::compare);
        Optional<Integer> max3Stream = nums.stream().max(Integer::compare);
        System.out.println("(Output stream) Min/Max : " + min3Stream.orElse(0) + "/" + max3Stream.orElse(0));
    }

    /**
     * Посчитай среднюю длину строк в списке.
     **/
    public static void averageWordLength(List<String> words) {
        double totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        double averageFor = totalLength / words.size();
        System.out.println("(Output loop) Average length : " + averageFor);

        double average = words.stream().mapToInt(String::length).average().orElse(0.0);
        System.out.println("(Output stream) Average length : " + average);
    }

    /**
     * Удали дубликаты и отсортируй строки по длине.
     **/
    public static void removeDuplicateAndSort(List<String> words) {
        List<String> resultFromLoop = new ArrayList<>(new HashSet<>(words));
        resultFromLoop.sort(Comparator.comparingInt(String::length));
        System.out.println("(Output loop) Remove duplicate words : " + resultFromLoop);
        List<String> resultFromStream = words.stream().distinct().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println("(Output stream) Remove duplicate words : " + resultFromStream);
    }

    /**
     * Преобразуй список строк в Map: ключ — строка, значение — длина.
     **/
    public static void mappingToHashMap(List<String> fruits) {
        Map<String, Integer> resultLoop = new HashMap<>();
        for (String fruit : fruits) {
            resultLoop.put(fruit, fruit.length());
        }
        System.out.println("(Output loop) Mapping to HashMap : " + resultLoop);

        Map<String, Integer> resultStream = fruits.stream().collect(Collectors.toMap(fruit -> fruit, String::length, (existing, replacement) -> existing));
        System.out.println("(Output stream) Mapping to HashMap : " + resultStream);
    }

    /**
     * Сгруппируй имена по первой букве.
     **/
    public static void sortingByFirstChart(List<String> namesList) {
        Map<Character, List<String>> result7For = new HashMap<>();
        for (String name : namesList) {
            char firstChar = name.charAt(0);
            result7For.computeIfAbsent(firstChar, k -> new ArrayList<>()).add(name);
        }

        System.out.println("(Output loop) Sorting by First Chart : " + result7For);

        Map<Character, List<String>> result7Stream = namesList.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("(Output stream) Sorting by First Chart : " + result7Stream);
    }

    /**
     * Собери список имён в одну строку через запятую.
     **/
    public static void joinName(List<String> names) {
        StringBuilder result8For = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            result8For.append(names.get(i));
            if (i < names.size() - 1) {
                result8For.append(",");
            }
        }
        System.out.println("(Output loop) Join name : " + result8For);

        String result8Stream = names.stream().collect(Collectors.joining(","));
        System.out.println("(Output stream) Join name : " + result8Stream);
    }

    /**
     * Из списка предложений получить список всех слов.
     **/
    public static void splitOfArray(List<String> sentences) {
        List<String> result9For = new ArrayList<>();
        for (String sentence : sentences) {
            String[] wordsArray = sentence.split(" ");
            result9For.addAll(Arrays.asList(wordsArray));
        }
        System.out.println("(Output loop) Split of Array : " + result9For);

        List<String> result9Stream = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).toList();
        System.out.println("(Output stream) Split of Array : " + result9Stream);
    }

    /**
     * Найди самый дорогой продукт в каждой категории.
     * record Product(String name, String category, double price) {}
     * <p>
     */
    public static void theAveragePriceInProducts(List<Product> products) {
        Map<String, Product> result10For = new HashMap<>();
        for (Product product : products) {
            Product currentMax = result10For.get(product.getCategory());
            if (currentMax == null || product.getPrice() > currentMax.getPrice()) {
                result10For.put(product.getCategory(), product);
            }
        }
        System.out.println("(Output loop) The avarage price in Product : " + result10For);

        // Через Stream API
        Map<String, Product> result10Stream = products.stream().collect(Collectors.toMap(Product::getCategory, Function.identity(), (p1, p2) -> p1.getPrice() > p2.getPrice() ? p1 : p2));
        System.out.println("(Output stream) The avarage price in Product : " + result10Stream);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> words = List.of("apple", "pear", "apple", "banana", "pear");
        List<Product> products = List.of(new Product("Phone", "Electronics", 1200), new Product("TV", "Electronics", 1800), new Product("Apple", "Fruits", 2.5), new Product("Mango", "Fruits", 4.0));
        //1
        evenIntInSquares(numbers);
        //2
        countLongStrings(words);
        //3
        maxAndMinNums(numbers);
        //4
        averageWordLength(words);
        //5
        removeDuplicateAndSort(words);
        //6
        mappingToHashMap(words);
        //7
        sortingByFirstChart(words);
        //8
        joinName(words);
        //9
        splitOfArray(words);
        //10
        theAveragePriceInProducts(products);
    }
}
