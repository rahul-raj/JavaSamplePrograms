package com.salestax.Concrete;

import com.salestax.Abstract.Item;
import com.salestax.Interface.IImportedTax;

public class ImportedFood extends Item implements IImportedTax{

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
    public void setItemPrice(double price) {
        super.setItemPrice(price);
        this.itemPrice = price;
    }


    @Override
    public double calculateImportedTax() {
        return 0.05*itemPrice;
    }

    @Override
    public double calculateTax() {
        return calculateImportedTax();
    }
}
