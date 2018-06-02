package com.fa.test.bill;

import com.fa.test.Displayable;
import com.fa.test.Displayer;
import com.fa.test.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Bill implements Displayable {

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    private List<Product> orderedProducts = new ArrayList<>();

    public void addProduct(Product product) {
        orderedProducts.add(product);
    }

    public String display(Displayer displayer) {
        return displayer.display(this);
    }

    public double getTotalPriceIncludingTaxes() {
        return orderedProducts.stream()
                .mapToDouble(o -> o.getPrice() + o.getTaxe().getTotalTaxe())
                .sum();
    }

    public double getTotalTaxes() {
        return orderedProducts.stream()
        .mapToDouble(product -> product.getTaxe().getTotalTaxe())
        .sum();
    }
}