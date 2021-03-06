package com.salestax.Concrete;

import com.salestax.Abstract.Item;

public class Book extends Item {

    private String isbnNo;
    private String title;
    private String author;
    private double itemPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        super.setItemName(title);
        this.title = title;
    }

    public String getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(String isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public void setItemPrice(double price) {
        super.setItemPrice(price);
        this.itemPrice = price;
    }
}
