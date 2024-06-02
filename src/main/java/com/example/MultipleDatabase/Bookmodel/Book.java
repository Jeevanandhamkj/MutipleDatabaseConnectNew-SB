package com.example.MultipleDatabase.Bookmodel;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

@Entity
@Table(name="BookDB")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book() {
    }
}
