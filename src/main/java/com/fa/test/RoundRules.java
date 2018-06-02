package com.fa.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundRules {

    private static int NUMBER_OF_DECIMAL_DIGITS = 2;

    public static double roundToNext5Cents(double valueToRound) {

        final double formatedValue = new BigDecimal(valueToRound).setScale(NUMBER_OF_DECIMAL_DIGITS, RoundingMode.FLOOR).doubleValue();

        final boolean canRoundToNext5Percent = (formatedValue * 100) % 5 != 0;

        if(canRoundToNext5Percent) {
            return Math.round(formatedValue * 20.0 + 0.5) / 20.0;
        } else {
            return formatedValue;
        }
    }

}
