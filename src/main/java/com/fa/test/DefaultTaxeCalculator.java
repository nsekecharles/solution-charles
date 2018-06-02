package com.fa.test;

public class DefaultTaxeCalculator implements TaxeCalculator {

    public DefaultTaxeCalculator() {
    }

    @Override
    public double vatTaxeValue(double unitPrice) {
        return round(unitPrice * 10 / 100);
    }
}
