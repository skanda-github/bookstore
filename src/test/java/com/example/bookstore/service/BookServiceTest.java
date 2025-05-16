package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private final BookRepository bookRepository = mock(BookRepository.class);
    private final BookService bookService = new BookService(bookRepository);

    @Test
    void testAddBook() {
        Book book = new Book("Java", "Author");
        when(bookRepository.save(book)).thenReturn(book);

        Book saved = bookService.addBook(book);
        assertEquals("Java", saved.getTitle());
    }

    @Test
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(List.of(new Book("Java", "Author")));
        List<Book> books = bookService.getAllBooks();
        assertEquals(1, books.size());
    }

    @Test
    void testGetBookById() {
        Book book = new Book("Java", "Author");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.getBookById(1L);
        assertTrue(result.isPresent());
    }
}