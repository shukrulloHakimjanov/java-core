package com.java.lessons.lesson03;
import java.util.ArrayList;
import java.util.List;

public class Book {
    String isbn;
    String name;
    String author;
    int year;
    String status;

    static List<Book> books = new ArrayList<>();

    public void getBookInfo() {
        System.out.println("[" + isbn + "] " + name + " - " + author + " (" + year + ") [" + status + "]");
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void addNewBook(Book book) {
        books.add(book);
        System.out.println("Добавлена книга: " + book.name);
    }

    public void reserveBook() {
        if ("доступна".equalsIgnoreCase(status)) {
            status = "зарезервирована";
            System.out.println("Книга \"" + name + "\" зарезервирована.");
        } else {
            System.out.println("Книга недоступна для брони.");
        }
    }
}
