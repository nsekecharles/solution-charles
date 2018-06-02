package com.fa.test.food;

import com.fa.test.taxe.TaxeCalculator;

public class FoodTaxeCalculator implements TaxeCalculator {

    @Override
    public double vatTaxeValue(double unitPrice) {
        return 0;
    }
}
