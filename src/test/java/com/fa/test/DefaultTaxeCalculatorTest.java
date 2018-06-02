package com.fa.test;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DefaultTaxeCalculatorTest {

    private DefaultTaxeCalculator sut = new DefaultTaxeCalculator();

    @Test
    public void should_return_a_taxe_of_10_percent_of_price() throws Exception {

        // Given
        double price = 10.0;

        // When
        Taxe taxe = sut.getTaxe(price, false);

        // Then
        Assertions.assertThat(taxe).isEqualTo(new Taxe(1.0, 0));

    }
}