package com.fa.test;

import com.fa.test.bill.Bill;
import com.fa.test.product.Product;

public interface Displayer {

    String display(Product product);

    String display(Bill bill);
}
