package com.example.jpa.demojpa.entity;

import javax.persistence.*;

@Entity
@Table(name="topic",schema = "demo_jpa",catalog = "demo_jpa")
public class Topic {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "book_id",referencedColumnName = "book_id")
    private Book book;

    public Topic() {
    }

    public Topic(String name, String description, Book book) {
        this.name = name;
        this.description = description;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
