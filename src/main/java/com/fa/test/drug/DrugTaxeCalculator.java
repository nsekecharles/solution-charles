package com.fa.test.drug;

import com.fa.test.taxe.TaxeCalculator;

public class DrugTaxeCalculator implements TaxeCalculator {

    @Override
    public double vatTaxeValue(double unitPrice) {
        return 0;
    }
}
