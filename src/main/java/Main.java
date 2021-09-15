import model.Product;
import service.DiscountService;
import service.DiscountServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        final BigDecimal totalDiscount = new BigDecimal("200.00");
        final List<Product> products = List.of(
                new Product("P1", new BigDecimal("333.00")),
                new Product("P2", new BigDecimal("333.00")),
                new Product("P3", new BigDecimal("333.00"))
        );
        run(totalDiscount, products);
    }

    private static void run(BigDecimal totalDiscount, List<Product> products) {
        DiscountService service = new DiscountServiceImpl(totalDiscount, products);
        presentResults(products, service.calculateDiscounts());
    }

    private static void presentResults(List<Product> products, BigDecimal[] productsDiscounts) {
        StringBuilder result = new StringBuilder("Results:\n");
        IntStream.range(0, products.size())
                .forEach(index -> {
                    result.append("discount for ")
                            .append(products.get(index).getName())
                            .append(" = ")
                            .append(productsDiscounts[index])
                            .append(" zł");
                    if (index < products.size() - 1) {
                        result.append("\n");
                    }
                });
        System.out.println(result.toString());
    }

}
