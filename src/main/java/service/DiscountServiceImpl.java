package service;

import model.Product;

import java.math.BigDecimal;
import java.util.List;

import static util.FinancialArithmetic.*;
import static util.Validator.*;

public class DiscountServiceImpl implements DiscountService {
    private final BigDecimal totalDiscount;
    private final BigDecimal totalPrice;
    private final List<Product> products;

    public DiscountServiceImpl(BigDecimal totalDiscount, List<Product> products) {
        validateInputData(totalDiscount, products);
        this.totalDiscount = totalDiscount;
        this.products = products;
        this.totalPrice = calculateTotalPrice();
    }

    @Override
    public BigDecimal[] calculateDiscounts() {
        BigDecimal[] discounts = precalculateDiscounts();
        BigDecimal difference = subtract(totalDiscount, addAll(discounts));
        if (difference.signum() == -1 || difference.signum() == 1) {
            correctLastDiscount(discounts, difference);
        }
        return discounts;
    }

    private BigDecimal[] precalculateDiscounts() {
        return products.stream()
                .map(this::calculatePercentage)
                .map(this::precalculateDiscount)
                .toArray(BigDecimal[]::new);
    }

    private BigDecimal precalculateDiscount(BigDecimal percentage) {
        return multiply(percentage, totalDiscount);
    }

    private BigDecimal calculatePercentage(Product product) {
        return divide(product.getPrice(), totalPrice);
    }

    private BigDecimal calculateTotalPrice() {
        return addAll(products.stream()
                .map(Product::getPrice)
                .toArray(BigDecimal[]::new));
    }

    private static void correctLastDiscount(BigDecimal[] array, BigDecimal correction) {
        int lastIndex = array.length - 1;
        array[lastIndex] = add(array[lastIndex], correction);
    }

    private static void validateInputData(BigDecimal totalDiscount, List<Product> products) {
        validateCurrencyValue(totalDiscount);
        validateProducts(products);
    }

}
