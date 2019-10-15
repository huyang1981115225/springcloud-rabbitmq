package com.yusys.springcloud.rabbitmq.entity;

/**
 * Created by huyang on 2019/10/15.
 */
public class Book {

    private String name;

    private Double price;

    public Book() {
    }

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
