package com.example.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    // Constructors, Getters and Setters
    public Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
