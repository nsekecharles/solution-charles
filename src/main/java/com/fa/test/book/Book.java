package com.fa.test.book;

import com.fa.test.Product;
import com.fa.test.Taxe;

public class Book extends Product {

    public Book(int quantiy, String name, double price, Taxe taxe) {
        super(quantiy, name, price, taxe);
    }
}
