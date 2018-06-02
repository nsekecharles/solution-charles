package com.fa.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface TaxeCalculator {

    default Taxe getTaxe(double price, boolean isImported) {

        double importationTaxe = isImported ? importationTaxeValue(price) : 0d;
        double vatTaxe = vatTaxeValue(price);

        return new Taxe(vatTaxe,importationTaxe);

    }

    double vatTaxeValue(double unitPrice);

    default double importationTaxeValue(double unitPrice) {
        return round(unitPrice * 5/100);
    }

    default double round(double value) {

        final double v = new BigDecimal(value).setScale(2, RoundingMode.FLOOR).doubleValue();

        if((v * 100) % 5 != 0) {
            return Math.round(v * 20 + 0.5) / 20.0d;
        } else {
            return v;
        }

    }
}
