package com.java.lessons.lesson03;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    String code;
    String name;
    double price;
    int count;

    static List<OnlineStore> products = new ArrayList<>();

    public static void addProduct(OnlineStore product) {
        products.add(product);
        System.out.println("Товар добавлен: " + product.name);
    }

    public void buyProduct(int quantity) {
        if (count >= quantity) {
            count -= quantity;
            System.out.println("Покупка: " + name + " x" + quantity + " | Остаток: " + count);
        } else {
            System.out.println("Недостаточно товара!");
        }
    }

    public void getProductInfo() {
        System.out.println(code + " | " + name + " | Цена: " + price + " | Кол-во: " + count);
    }

    public static List<OnlineStore> getProducts() {
        return products;
    }
}
