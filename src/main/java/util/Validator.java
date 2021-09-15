package util;

import model.Product;

import java.math.BigDecimal;
import java.util.List;

public class Validator {
    private static final int MIN_LIST_SIZE = 1;
    private static final int MAX_LIST_SIZE = 5;
    public static final String INCORRECT_LIST_SIZE_MESSAGE = String.format("ProductList should contain from %d to %d items", MIN_LIST_SIZE, MAX_LIST_SIZE);
    public static final String NULL_CURRENCY_VALUE_MESSAGE = "Currency value cannot be null";
    public static final String NEGATIVE_NUMBER_CURRENCY_VALUE_MESSAGE = "Currency value must be a positive number";
    public static final String INCORRECT_NUMBER_OF_DECIMAL_PLACES_MESSAGE = "Currency value must contain exactly two decimal places";
    public static final String NULL_NAME_MESSAGE = "Product name cannot be null";
    public static final String EMPTY_NAME_MESSAGE = "Product name cannot be empty";
    public static final String BLANK_NAME_MESSAGE = "Product name cannot contains only white space";

    private Validator() {
    }

    public static void validateProducts(List<Product> products) {
        int size = products.size();
        if (size < MIN_LIST_SIZE || size > MAX_LIST_SIZE) {
            throw new IllegalArgumentException(INCORRECT_LIST_SIZE_MESSAGE);
        }
        products.forEach(Validator::validateProduct);
    }

    public static void validateCurrencyValue(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException(NULL_CURRENCY_VALUE_MESSAGE);
        }
        if (price.signum() < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_CURRENCY_VALUE_MESSAGE);
        }
        String[] priceAsStringArray = price.toString().split("\\.");
        if (priceAsStringArray.length == 1) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_OF_DECIMAL_PLACES_MESSAGE);
        }
        String decimalPlaces = priceAsStringArray[1];
        if (decimalPlaces.length() != 2) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_OF_DECIMAL_PLACES_MESSAGE);
        }
    }

    private static void validateProduct(Product product) {
        validateName(product.getName());
        validateCurrencyValue(product.getPrice());
    }

    private static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NULL_NAME_MESSAGE);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_MESSAGE);
        }
    }

}
