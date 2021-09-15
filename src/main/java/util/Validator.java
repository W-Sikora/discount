package util;

import model.Product;

import java.math.BigDecimal;
import java.util.List;

public class Validator {
    private static final int MIN_LIST_SIZE = 1;
    private static final int MAX_LIST_SIZE = 5;
    private static final String VALID_CURRENCY_FORMAT = "\\d+\\.\\d{2}";
    private static final String INVALID_LIST_SIZE_MESSAGE = "ProductList should contain from %d to %d items";
    private static final String INVALID_CURRENCY_VALUE_MESSAGE = "Currency value cannot be null and must follow the format ###.##";
    private static final String INVALID_NAME_MESSAGE = "Product name cannot be null, empty and start with whitespace characters";

    private Validator() {
    }

    public static void validateProducts(List<Product> products) {
        int size = products.size();
        if (size < MIN_LIST_SIZE || size > MAX_LIST_SIZE) {
            throw new IllegalArgumentException(String.format(INVALID_LIST_SIZE_MESSAGE, MIN_LIST_SIZE, MAX_LIST_SIZE));
        }
        products.forEach(Validator::validateProduct);
    }

    public static void validateCurrency(BigDecimal price) {
        if (price == null || !isCurrencyFormatValid(price)) {
            throw new IllegalArgumentException(INVALID_CURRENCY_VALUE_MESSAGE);
        }
    }

    private static void validateProduct(Product product) {
        validateName(product.getName());
        validateCurrency(product.getPrice());
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
    }

    private static boolean isCurrencyFormatValid(BigDecimal price) {
        return price.toString().matches(VALID_CURRENCY_FORMAT);
    }

}
