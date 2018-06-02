package com.fa.test.food;

import com.fa.test.Product;
import com.fa.test.Taxe;

public class Food extends Product {

    public Food(int quantiy, String name, double price, Taxe taxe) {
        super(quantiy, name, price, taxe);
    }
}
