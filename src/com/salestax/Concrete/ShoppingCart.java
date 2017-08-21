package com.salestax.Concrete;

import com.salestax.Abstract.Item;


import java.util.Map;

public class ShoppingCart {
    private Map<Item,Integer> itemList;

    public Map<Item, Integer> getItemList() {
        return itemList;
    }

    public void setItemList(Map<Item, Integer> itemList) {
        this.itemList = itemList;
    }

    public void generateBill(){
        listItems();
        System.out.println("************************************************");
        calculateTotal();
        System.out.println("************************************************");
    }
    public void listItems(){
        System.out.println("Items:");
        for(Map.Entry<Item,Integer> entry : itemList.entrySet()){
            System.out.println(entry.getKey().getItemName()+", count: "+entry.getValue()+" Price: "+entry.getKey().getItemPrice()+", Tax: "+entry.getKey().calculateTax());
        }
    }
    public void calculateTotal(){
        System.out.println("Purchase Summary: ");
        double sum=0.0;
        for(Map.Entry<Item,Integer> entry : itemList.entrySet()){
            System.out.println(entry.getKey().getItemName()+" -> "+entry.getKey().getItemPrice()*entry.getValue());
            sum+=entry.getKey().getItemPrice();
        }
        System.out.println("Total Amount to be Paid: "+ (sum+calculateTotalTax()));
        System.out.println("Total Tax Included: "+calculateTotalTax());
    }
    public double calculateTotalTax(){
        double tax=0.0;
        for(Map.Entry<Item,Integer> entry : itemList.entrySet()){
            tax=tax+entry.getKey().calculateTax()*entry.getValue();
        }
        return tax;
    }
}
