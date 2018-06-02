package com.fa.test;

import org.junit.Test;

import static com.fa.test.Product.isImported;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {


    @Test
    public void product_name_ending_with_importe_is_imported() throws Exception {

        final String name = "tetet importé";

        assertThat(isImported(name)).isTrue();
    }

    @Test
    public void product_name_ending_with_importee_is_imported() throws Exception {

        final String name = "tetet importée";

        assertThat(isImported(name)).isTrue();
    }

    @Test
    public void product_name_ending_without_imported_sign_is_not_imported() throws Exception {

        final String name = "tetet";

        assertThat(isImported(name)).isFalse();
    }
}