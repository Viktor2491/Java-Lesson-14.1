package ru.netology.domain;
public class Book extends ru.netology.domain.Product {
    private String author;


    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    // public void setAuthor(String author) {
    //       this.author = author;
    //  }

}

