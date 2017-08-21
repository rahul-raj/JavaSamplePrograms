package com.salestax.Abstract;

import com.salestax.Interface.ITax;

public abstract class Item implements ITax{
    private String itemName;
    private double itemPrice;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double calculateTax(){return 0.0;}
}
