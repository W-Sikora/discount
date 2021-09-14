package service;

import model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static util.FinancialArithmetic.*;

public class DiscountServiceImpl implements DiscountService {
    private final BigDecimal totalDiscount;
    private final BigDecimal totalPrice;
    private final List<Product> products;
    private List<BigDecimal> discounts;

    public DiscountServiceImpl(BigDecimal totalDiscount, List<Product> products) {
        this.totalDiscount = totalDiscount;
        this.products = products;
        this.totalPrice = calculateTotalPrice();
    }

    @Override
    public List<BigDecimal> getDiscounts() {
        this.discounts = calculateAllDiscounts();
        BigDecimal difference = subtract(totalDiscount, addAll(discounts));
        System.out.println(difference);
        if (difference.signum() > 0) {
            correctLastDiscount(difference);
        }
        return discounts;
    }

    private List<BigDecimal> calculateAllDiscounts() {
        return products.stream()
                .map(this::calculatePercentage)
                .map(this::calculateDiscount)
                .collect(Collectors.toList());
    }

    private BigDecimal calculateDiscount(BigDecimal percentage) {
        return multiply(percentage, totalDiscount);
    }

    private BigDecimal calculatePercentage(Product product) {
        return divide(product.getPrice(), totalPrice);
    }

    private BigDecimal calculateTotalPrice() {
        return addAll(products.stream()
                .map(Product::getPrice));
    }

    private void correctLastDiscount(BigDecimal correction) {
        int lastIndex = discounts.size() - 1;
        discounts.add(lastIndex, discounts.get(lastIndex).add(correction));
    }

}
