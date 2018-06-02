package com.fa.test.drug;

import com.fa.test.product.Product;
import com.fa.test.taxe.Taxe;

public class Drug extends Product {

    public Drug(int quantiy, String name, double price, Taxe taxe) {
        super(quantiy, name, price, taxe);
    }
}
