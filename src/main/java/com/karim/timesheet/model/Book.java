/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.model;

/**
 *
 * @author karim
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publishedDate;
    private float price;
 
    public Book(String title, String author, String isbn, String publishedDate,
            float price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public float getPrice() {
        return price;
    }
 
    
 
}
