package com.fa.test.book;

import com.fa.test.Taxe;
import com.fa.test.TaxeCalculator;
import com.fa.test.TaxeCalulatorTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BookTaxeCalculatorTest extends TaxeCalulatorTest {

    private BookTaxeCalculator sut = new BookTaxeCalculator();

    @Test
    public void should_not_apply_vat_for_books() throws Exception {

        // Given
        double price = 120.0;

        // When
        Taxe taxe = sut.getTaxe(price, false);

        // Then
        Assertions.assertThat(taxe).isEqualTo(Taxe.ZERO);

    }

    @Override
    public TaxeCalculator getCalculatorToTest() {
        return sut;
    }
}