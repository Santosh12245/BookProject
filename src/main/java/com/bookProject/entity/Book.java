package com.bookProject.entity;

import jakarta.persistence.*;
import org.hibernate.dialect.MySQLDialect;

@Entity
@Table(name = "books")
public class Book {
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String title ;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(int id, String title, Author author) {
        super() ;
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public Book(){

    }
}
