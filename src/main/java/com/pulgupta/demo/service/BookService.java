package com.pulgupta.demo.service;

import com.pulgupta.demo.model.Book;
import com.pulgupta.demo.repository.BooksRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class BookService {

    @Inject
    BooksRepository booksRepository;

    public Book getBook(String id) {
        return booksRepository.getBooks().get(id);
    }

    public List<Book> getAllBooks() {
        List<Book> result = new ArrayList();
        result.addAll(booksRepository.getBooks().values());
        return result;
    }

    public void addBook(Book book) {
        booksRepository.getBooks().put(book.getId(), book);
    }
}
