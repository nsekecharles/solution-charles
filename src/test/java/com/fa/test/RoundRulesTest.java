package com.fa.test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundRulesTest {

    @Test
    public void should_return_0_0_given_0_0() throws Exception {

        final double roundedValue = RoundRules.roundToNext5Cents(0.0);

        assertThat(roundedValue).isEqualTo(0.00);
    }

    @Test
    public void should_return_1_05_given_1_04() throws Exception {

        final double roundedValue = RoundRules.roundToNext5Cents(1.04);

        assertThat(roundedValue).isEqualTo(1.05);
    }

    @Test
    public void should_return_1_15_given_1_15() throws Exception {

        final double roundedValue = RoundRules.roundToNext5Cents(1.15);

        assertThat(roundedValue).isEqualTo(1.15);
    }


    @Test
    public void should_return_0_55_given_0_54() throws Exception {

        final double roundedValue = RoundRules.roundToNext5Cents(0.54);

        assertThat(roundedValue).isEqualTo(0.55);
    }

    @Test
    public void should_return_3_7_given_3_7() throws Exception {

        final double roundedValue = RoundRules.roundToNext5Cents(3.7);

        assertThat(roundedValue).isEqualTo(3.7);
    }
}