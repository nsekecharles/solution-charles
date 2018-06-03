package com.fa.test;

import com.fa.test.book.Book;
import com.fa.test.drug.Drug;
import com.fa.test.food.Food;
import com.fa.test.product.Product;
import com.fa.test.product.ProductFactory;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductFactoryTest {

    private List<Class> productSubClasses = Arrays.asList(Food.class, Drug.class, Book.class);
    private ProductFactory sut = new ProductFactory();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_return_a_product_given_unknown_type_product_name() throws Exception {

        // When
        Product product = sut.create(1, "produit de type inconnu", 12.0);

        // Then
        assertThat(product).isInstanceOf(Product.class);
        assertThat(product).isNotInstanceOfAny((Class<?>[]) productSubClasses.toArray());
    }

    @Test
    public void should_return_a_book_given_book_product_name() throws Exception {

        // When
        Product product = sut.create(1, Configuration.BOOKS.get(0), 12.0);

        // Then
        assertThat(product).isInstanceOf(Book.class);
    }

    @Test
    public void should_return_a_food_given_food_product_name() throws Exception {

        // When
        Product product = sut.create(1, Configuration.FOODS.get(0), 12.0);

        // Then
        assertThat(product).isInstanceOf(Food.class);
    }

    @Test
    public void should_return_a_drug_given_food_product_name() throws Exception {

        // When
        Product product = sut.create(1, Configuration.DRUGS.get(0), 12.0);

        // Then
        assertThat(product).isInstanceOf(Drug.class);
    }

    @Test
    public void should_not_create_a_product_without_a_name() throws Exception {

        exception.expect(InvalidProductException.class);
        exception.expectMessage("Product name is absent");

        sut.create(1, "", 12.0);
    }

    @Test
    public void should_not_create_a_product_with_a_negative_price() throws Exception {

        exception.expect(InvalidProductException.class);
        exception.expectMessage("Product price should not be equals or less than 0");

        sut.create(1, "invalid product", -12.0);
    }

    @Test
    public void should_not_create_a_product_with_a_price_of_0() throws Exception {

        exception.expect(InvalidProductException.class);
        exception.expectMessage("Product price should not be equals or less than 0");

        sut.create(1, "invalid product", 0.0);
    }

    @Test
    public void should_not_create_a_product_with_a_quantity_of_0() throws Exception {

        exception.expect(InvalidProductException.class);
        exception.expectMessage("Product quantity should not be equals or less than 0");

        sut.create(0, "invalid product", 1.0);
    }

    @Test
    public void should_not_create_a_product_with_a_negative_quantity() throws Exception {

        exception.expect(InvalidProductException.class);
        exception.expectMessage("Product quantity should not be equals or less than 0");

        sut.create(-1, "invalid product", 1.0);
    }
}