package com.fa.test.drug;

import com.fa.test.Product;
import com.fa.test.Taxe;

public class Drug extends Product {

    public Drug(int quantiy, String name, double price, Taxe taxe) {
        super(quantiy, name, price, taxe);
    }
}
