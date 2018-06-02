package com.fa.test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class Configuration {

    public static final List<String> FOODS = Arrays.asList("barre de chocolat",
            "boîte de chocolats importée",
            "boîte de chocolats importés");

    public static final List<String> BOOKS = Arrays.asList("livre");

    public static final List<String> DRUGS = Arrays.asList("boîte de pilules contre la migraine");

    static DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(' ');
        return dfs;
    }

    public static NumberFormat numberFormat = new DecimalFormat("#0.00", getDecimalFormatSymbols());

    public static Displayer displayer = new DefaultDisplayer();
}
