package com.fa.test.product;

import com.fa.test.book.Book;
import com.fa.test.drug.Drug;
import com.fa.test.food.Food;
import com.fa.test.taxe.DefaultTaxeCalculator;

import java.util.Optional;

import static com.fa.test.product.Product.isImported;

public class ProductFactory {

    public Product create(int quantiy, String name, double price) {

        Optional<ProductType> type = ProductType.fromName(name);

        if(type.isPresent()) {
            switch (type.get()) {
                case FOOD:
                    return new Food(quantiy, name, price, type.get().getTaxeCalculator().getTaxe(price, isImported(name)));
                case BOOK:
                    return new Book(quantiy, name, price, type.get().getTaxeCalculator().getTaxe(price, isImported(name)));
                case DRUG:
                    return new Drug(quantiy, name, price, type.get().getTaxeCalculator().getTaxe(price, isImported(name)));
            }
        }

        return new Product(quantiy, name, price, new DefaultTaxeCalculator().getTaxe(price, isImported(name)));
    }
}
