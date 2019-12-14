package com.pulgupta.demo.repository;

import com.pulgupta.demo.model.Book;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
public class BooksRepository {
    private Map<UUID, Book> books;

    public BooksRepository() {
        Book book1 = new Book();
        book1.setName("The Unicorn Project");
        book1.setAuthor("Jhon Doe");
        book1.setCategory("Fiction");

        Book book2 = new Book();
        book2.setName("Head First Java");
        book2.setAuthor("Tom Lee");
        book2.setCategory("Computers");

        this.books = new HashMap<>();
        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
    }

    public Map<UUID, Book> getBooks() {
        return books;
    }
}