package com.fa.test;

import com.fa.test.taxe.Taxe;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxeTest {

    @Test
    public void should_not_be_equals_to_non_taxe_object() throws Exception {
        // Given
        final Taxe taxe = new Taxe(1.0, 1.0);

        // Then
        assertThat(taxe).isNotEqualTo(new Object());
    }

    @Test
    public void should_return_importation_taxe_plus_vat_taxe_when_getting_total_taxe() throws Exception {

        // Given
        final Taxe taxe = new Taxe(1.0, 1.0);

        // Then
        assertThat(taxe.getTotalTaxe()).isEqualTo(2.0);
    }
}
