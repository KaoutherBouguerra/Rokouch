package com.zedney.rokouch.models;

import java.util.ArrayList;

public class Category {

    String title;
    ArrayList<Book> books ;

    public Category(String title, ArrayList<Book> books) {
        this.title = title;
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
