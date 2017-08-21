package com.salestax;

import com.salestax.Abstract.Item;
import com.salestax.Concrete.*;

import java.util.HashMap;
import java.util.Map;

public class BillClient {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Map<Item,Integer> map = new HashMap<Item,Integer>();
        //Item oreilly = new Book();
        //oreilly.setItemName("book");
        //oreilly.setItemPrice(12.49);
        //Item eminemCD = new Others();
        //eminemCD.setItemName("music");
        //eminemCD.setItemPrice(14.99);
        Item chocolate = new ImportedFood();
        chocolate.setItemName("Imported chocolate");
        chocolate.setItemPrice(10.00);
        Item perfume = new ImportedOthers();
        perfume.setItemName("Perfume");
        perfume.setItemPrice(47.50);
        //map.put(oreilly,1);
        //map.put(eminemCD,1);
        map.put(chocolate,1);
        map.put(perfume,1);
        cart.setItemList(map);
        cart.generateBill();
    }
}
