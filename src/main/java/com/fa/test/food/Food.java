package com.fa.test.food;

import com.fa.test.product.Product;
import com.fa.test.taxe.Taxe;

public class Food extends Product {

    public Food(int quantiy, String name, double price, Taxe taxe) {
        super(quantiy, name, price, taxe);
    }
}
