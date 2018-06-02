package com.fa.test.book;

import com.fa.test.taxe.TaxeCalculator;

public class BookTaxeCalculator implements TaxeCalculator {

    @Override
    public double vatTaxeValue(double unitPrice) {
        return 0;
    }
}
