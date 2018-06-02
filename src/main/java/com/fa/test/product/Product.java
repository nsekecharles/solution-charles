package com.fa.test.product;


import com.fa.test.Displayable;
import com.fa.test.Displayer;
import com.fa.test.taxe.Taxe;

public class Product implements Displayable {

    private final int quantity;
    private final String name;
    private final double price;
    private final Taxe taxe;

    public Product(int quantity, String name, double price, Taxe taxe) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.taxe = taxe;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Taxe getTaxe() {
        return taxe;
    }

    public String display(Displayer displayer) {
        return displayer.display(this);
    }

    public static boolean isImported(String name) {
        return name != null && name.matches(".*(importé|importée|importés)$");
    }
}
