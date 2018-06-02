package com.fa.test;

import com.fa.test.bill.Bill;
import com.fa.test.product.Product;

import static com.fa.test.Configuration.numberFormat;
import static java.util.stream.Collectors.joining;

public class DefaultDisplayer implements Displayer {

    @Override
    public String display(Product product) {
        return product.getQuantity() + " "
                + product.getName() + " : " + numberFormat.format(product.getPrice() + product.getTaxe().getTotalTaxe());
    }

    @Override
    public String display(Bill bill) {
        return bill.getOrderedProducts().stream()
                .map(r -> r.display(this))
                .collect(joining("\n"))
                .concat("\n")
                .concat("Montant des taxes : " +
                        numberFormat.format(bill.getTotalTaxes())
                                .concat("\n")
                                .concat("Total : " +
                                        numberFormat.format(bill.getTotalPriceIncludingTaxes())));
    }
}
