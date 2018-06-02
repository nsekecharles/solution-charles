package com.fa.test;

import com.fa.test.taxe.DefaultTaxeCalculator;
import com.fa.test.taxe.Taxe;
import com.fa.test.taxe.TaxeCalculator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultTaxeCalculatorTest extends TaxeCalculatorTest {

    private DefaultTaxeCalculator sut = new DefaultTaxeCalculator();

    @Test
    public void should_return_a_taxe_of_10_percent_of_price() throws Exception {

        // Given
        double price = 10.0;

        // When
        Taxe taxe = sut.getTaxe(price, false);

        // Then
        assertThat(taxe).isEqualTo(new Taxe(1.0, 0));

    }

    @Override
    public TaxeCalculator getCalculatorToTest() {
        return sut;
    }
}