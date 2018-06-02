package com.fa.test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class TaxeCalulatorTest {

    @Test
    public void should_have_importation_taxe_for_imported_product() {

        // When
        Taxe taxe = getCalculatorToTest().getTaxe(10.0, true);

        // Then
        assertThat(taxe.getImportationTaxe()).isEqualTo(10.0 * 5 / 100);
    }

    @Test
    public void should_have_0_importation_taxe_for_not_imported_product() {

        // When
        Taxe taxe = getCalculatorToTest().getTaxe(100.0, false);

        // Then
        assertThat(taxe.getImportationTaxe()).isZero();
    }

    public abstract TaxeCalculator getCalculatorToTest();
}
