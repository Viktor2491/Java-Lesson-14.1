package ru.netology.domain;

public class Product {
    protected int id;
    protected String title;
    protected int price;

    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    //   public void setId(int id) {
    //     this.id = id;
    //   }

    public String getTitle() {
        return title;
    }


}
