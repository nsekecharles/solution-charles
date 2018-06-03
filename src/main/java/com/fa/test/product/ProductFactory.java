package com.fa.test.product;

import com.fa.test.InvalidProductException;
import com.fa.test.book.Book;
import com.fa.test.drug.Drug;
import com.fa.test.food.Food;
import com.fa.test.taxe.DefaultTaxeCalculator;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

import static com.fa.test.product.Product.isImported;

public class ProductFactory {

    public Product create(int quantiy, String name, double price) {

        validateName(name);
        validatePrice(price);
        validateQuantity(quantiy);

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

    private void validateQuantity(int quantiy) {
        if(quantiy <= 0) {
            throw new InvalidProductException("Product quantity should not be equals or less than 0");
        }
    }

    private void validatePrice(double price) {
        if(price <= 0) {
            throw new InvalidProductException("Product price should not be equals or less than 0");
        }
    }

    private void validateName(String name) {
        if(StringUtils.isEmpty(name)) {
            throw new InvalidProductException("Product name is absent");
        }
    }
}
