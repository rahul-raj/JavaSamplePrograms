package com.salestax.Concrete;

import com.salestax.Abstract.Item;

public class Food extends Item {

    private String itemName;
    private double itemPrice;

    @Override
    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override

    public String getItemName() {
        return itemName;
    }

    @Override
    public void setItemName(String itemName) {
        super.setItemName(itemName);
        this.itemName = itemName;
    }


}
