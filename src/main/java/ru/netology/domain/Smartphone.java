package ru.netology.domain;
public class Smartphone extends ru.netology.domain.Product {
    private String manufacturer;

    public Smartphone(int id, String title, int price, String manufacturer) {
        super(id, title, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    //  public void setManufacturer(String manufacturer) {
    //     this.manufacturer = manufacturer;
    // }

}