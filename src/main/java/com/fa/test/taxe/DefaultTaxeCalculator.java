package com.fa.test.taxe;

public class DefaultTaxeCalculator implements TaxeCalculator {

    public static final double TEN_PERCENT_RATE = 10.0 / 100.0;

    public DefaultTaxeCalculator() {
    }

    @Override
    public double vatTaxeValue(double unitPrice) {
        return unitPrice * TEN_PERCENT_RATE;
    }
}
