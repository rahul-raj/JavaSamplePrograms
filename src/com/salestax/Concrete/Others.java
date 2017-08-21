package com.salestax.Concrete;

import com.salestax.Abstract.Item;
import com.salestax.Interface.IBasicTax;

public class Others extends Item implements IBasicTax {

    private String itemName;
    private double itemPrice;

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public void setItemName(String itemName) {
        super.setItemName(itemName);
        this.itemName = itemName;
    }

    @Override
    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double calculateBasicTax() {
        return 0.1*itemPrice;
    }

    @Override
    public double calculateTax() {
        return calculateBasicTax();
    }
}
