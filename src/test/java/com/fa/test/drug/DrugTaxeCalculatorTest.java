package com.fa.test.drug;

import com.fa.test.Taxe;
import com.fa.test.TaxeCalculator;
import com.fa.test.TaxeCalulatorTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrugTaxeCalculatorTest extends TaxeCalulatorTest {

    private DrugTaxeCalculator sut = new DrugTaxeCalculator();

    @Test
    public void should_not_apply_vat_for_drugs() throws Exception {

        // Given
        double price = 120.0;

        // When
        Taxe taxe = sut.getTaxe(price, false);

        // Then
        assertThat(taxe).isEqualTo(Taxe.ZERO);

    }

    @Override
    public TaxeCalculator getCalculatorToTest() {
        return sut;
    }
}