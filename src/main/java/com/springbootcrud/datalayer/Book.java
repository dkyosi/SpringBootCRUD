package com.springbootcrud.datalayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Book {
    @SequenceGenerator(sequenceName = "book_generator",name = "book_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_generator")
    @Id
    private long bookId;
    private String bookTitle;
    private String author;
    private Date createdAt;

    public Book(String bookTitle, String author) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.createdAt =  new Date();
    }
}
