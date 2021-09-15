package util;

import model.Product;

import java.math.BigDecimal;
import java.util.List;

public class Validator {
    private static final int MIN_LIST_SIZE = 1;
    private static final int MAX_LIST_SIZE = 5;
    private static final String VALID_CURRENCY_FORMAT = "\\d+\\.\\d{2}";
    private static final String INVALID_LIST_SIZE_MESSAGE = String.format("ProductList should contain from %d to %d items", MIN_LIST_SIZE, MAX_LIST_SIZE);
    private static final String NULL_CURRENCY_VALUE_MESSAGE = "Currency value cannot be null";
    private static final String NEGATIVE_NUMBER_CURRENCY_VALUE_MESSAGE = "Currency value must be a positive number";
    private static final String INVALID_FORMAT_CURRENCY_VALUE_MESSAGE = "Currency value must be in `###.##` format";
    private static final String NULL_NAME_MESSAGE = "Product name cannot be null";
    private static final String EMPTY_NAME_MESSAGE = "Product name cannot be empty";
    private static final String BLANK_NAME_MESSAGE = "Product name cannot contains only white space";

    private Validator() {
    }

    public static void validateProducts(List<Product> products) {
        int size = products.size();
        if (size < MIN_LIST_SIZE || size > MAX_LIST_SIZE) {
            throw new IllegalArgumentException(INVALID_LIST_SIZE_MESSAGE);
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
        if (!isCurrencyFormatValid(price)) {
            throw new IllegalArgumentException(INVALID_FORMAT_CURRENCY_VALUE_MESSAGE);
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

    private static boolean isCurrencyFormatValid(BigDecimal price) {
        return price.toString().matches(VALID_CURRENCY_FORMAT);
    }

}
