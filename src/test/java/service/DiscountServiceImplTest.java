package service;

import model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceImplTest {

    private DiscountService service;
    private BigDecimal totalDiscount;
    private List<Product> products;

    @Test
    @DisplayName("discount for single product")
    void discountForSingleProduct() {
        totalDiscount = new BigDecimal("99.99");
        products = List.of(
                new Product("Product 1", new BigDecimal("1111.11"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[99.99]", Arrays.toString(service.calculateDiscounts()));
    }

    @Test
    @DisplayName("discounts for two products with equal percentages")
    void discountsForTwoProductsWithEqualPercentages() {
        totalDiscount = new BigDecimal("1000.00");
        products = List.of(
                new Product("Product 1", new BigDecimal("700.00")),
                new Product("Product 2", new BigDecimal("700.00"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[500.00, 500.00]", Arrays.toString(service.calculateDiscounts()));
    }

    @Test
    @DisplayName("discounts for two products with not equal percentages")
    void discountsForTwoProductsWithNotEqualPercentages() {
        totalDiscount = new BigDecimal("100.00");
        products = List.of(
                new Product("Product 1", new BigDecimal("700.00")),
                new Product("Product 2", new BigDecimal("72.35"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[90.63, 9.37]", Arrays.toString(service.calculateDiscounts()));
    }

    @Test
    @DisplayName("discounts for three products with equal percentages")
    void discountsForThreeProductsWithEqualPercentages() {
        totalDiscount = new BigDecimal("20.00");
        products = List.of(
                new Product("Product 1", new BigDecimal("33.00")),
                new Product("Product 2", new BigDecimal("33.00")),
                new Product("Product 3", new BigDecimal("33.00"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[6.67, 6.67, 6.66]", Arrays.toString(service.calculateDiscounts()));
    }

    @Test
    @DisplayName("discounts for three products with not equal percentages")
    void discountsForThreeProductsWithNotEqualPercentages() {
        totalDiscount = new BigDecimal("200.00");
        products = List.of(
                new Product("Product 1", new BigDecimal("300.07")),
                new Product("Product 2", new BigDecimal("131.00")),
                new Product("Product 3", new BigDecimal("233.33"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[90.33, 39.43, 70.24]", Arrays.toString(service.calculateDiscounts()));
    }

    @Test
    @DisplayName("discounts for four products with equal percentages")
    void discountsForFourProductsWithEqualPercentages() {
        totalDiscount = new BigDecimal("277.00");
        products = List.of(
                new Product("Product 1", new BigDecimal("250.00")),
                new Product("Product 2", new BigDecimal("250.00")),
                new Product("Product 3", new BigDecimal("250.00")),
                new Product("Product 4", new BigDecimal("250.00"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[69.25, 69.25, 69.25, 69.25]", Arrays.toString(service.calculateDiscounts()));
    }

    @Test
    @DisplayName("discounts for four products with not equal percentages")
    void discountsForFourProductsWithNotEqualPercentages() {
        totalDiscount = new BigDecimal("333.33");
        products = List.of(
                new Product("Product 1", new BigDecimal("123.00")),
                new Product("Product 2", new BigDecimal("456.78")),
                new Product("Product 3", new BigDecimal("900.00")),
                new Product("Product 4", new BigDecimal("1199.99"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[15.30, 56.82, 111.95, 149.26]", Arrays.toString(service.calculateDiscounts()));
    }

    @Test
    @DisplayName("discounts for five products with equal percentages")
    void discountsForFiveProductsWithEqualPercentages() {
        totalDiscount = new BigDecimal("77.77");
        products = List.of(
                new Product("Product 1", new BigDecimal("210.00")),
                new Product("Product 2", new BigDecimal("210.00")),
                new Product("Product 3", new BigDecimal("210.00")),
                new Product("Product 4", new BigDecimal("210.00")),
                new Product("Product 5", new BigDecimal("210.00"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[15.55, 15.55, 15.55, 15.55, 15.57]", Arrays.toString(service.calculateDiscounts()));
    }

    @Test
    @DisplayName("discounts for five products with not equal percentages")
    void discountsForFiveProductsWithNotEqualPercentages() {
        totalDiscount = new BigDecimal("2500.01");
        products = List.of(
                new Product("Product 1", new BigDecimal("321.99")),
                new Product("Product 2", new BigDecimal("23.33")),
                new Product("Product 3", new BigDecimal("7800.00")),
                new Product("Product 4", new BigDecimal("11999.99"))
        );
        service = new DiscountServiceImpl(totalDiscount, products);
        assertEquals("[39.96, 2.90, 967.97, 1489.18]", Arrays.toString(service.calculateDiscounts()));
    }

}
