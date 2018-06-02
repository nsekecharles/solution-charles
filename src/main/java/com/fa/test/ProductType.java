package com.fa.test;

import com.fa.test.book.BookTaxeCalculator;
import com.fa.test.drug.DrugTaxeCalculator;
import com.fa.test.food.FoodTaxeCalculator;

import java.util.List;
import java.util.Optional;

import static com.fa.test.Configuration.BOOKS;
import static com.fa.test.Configuration.DRUGS;
import static com.fa.test.Configuration.FOODS;

public enum ProductType {

    FOOD(FOODS, new FoodTaxeCalculator()),
    BOOK(BOOKS, new BookTaxeCalculator()),
    DRUG(DRUGS, new DrugTaxeCalculator());

    private List<String> associatedNames;
    private TaxeCalculator taxeCalculator;

    ProductType(List<String> associatedNames, TaxeCalculator taxeCalculator) {
        this.associatedNames = associatedNames;
        this.taxeCalculator = taxeCalculator;
    }

    public static Optional<ProductType> fromName(String name) {
        for(ProductType type : values()) {
            if(type.associatedNames.contains(name)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    public TaxeCalculator getTaxeCalculator() {
        return taxeCalculator;
    }
}
