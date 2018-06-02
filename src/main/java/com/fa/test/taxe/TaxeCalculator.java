package com.fa.test.taxe;

import static com.fa.test.RoundRules.roundToNext5Cents;

public interface TaxeCalculator {

    double RATE_OF_5_PERCENT = 5.0 / 100.0;

    default Taxe getTaxe(double price, boolean isImported) {

        double importationTaxe = isImported ? importationTaxeValue(price) : 0d;
        double vatTaxe = roundToNext5Cents(vatTaxeValue(price));

        return new Taxe(vatTaxe,importationTaxe);

    }

    double vatTaxeValue(double unitPrice);

    default double importationTaxeValue(double unitPrice) {
        return roundToNext5Cents(unitPrice * RATE_OF_5_PERCENT);
    }

}
