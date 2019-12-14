package com.pulgupta.demo.resolver;

import com.pulgupta.demo.graphql.DemoResolver;
import com.pulgupta.demo.model.Book;
import com.pulgupta.demo.service.BookService;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.inject.Inject;
import java.util.List;

@DemoResolver
public class BookResolver {

    @Inject
    BookService bookService;

    @GraphQLQuery(name="getBooks", description="Get all books")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }
}