import model.Product;
import service.DiscountService;
import service.DiscountServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final BigDecimal totalDiscount = new BigDecimal("111.11");
        final List<Product> products = List.of(
                new Product("P1", new BigDecimal("333")),
                new Product("P2", new BigDecimal("1333")),
                new Product("P3", new BigDecimal("233"))
        );
        run(totalDiscount, products);
    }

    private static void run(BigDecimal totalDiscount, List<Product> products) {
        DiscountService service = new DiscountServiceImpl(totalDiscount, products);
        List<BigDecimal> productsDiscounts = service.getDiscounts();
        presentResults(products, productsDiscounts);
    }

    private static void presentResults(List<Product> products, List<BigDecimal> productsDiscounts) {
        StringBuilder result = new StringBuilder("Results:\n");
        for (int i = 0; i < products.size(); i++) {
            result.append("\tdiscount for ")
                    .append(products.get(i))
                    .append(" = ")
                    .append(productsDiscounts.get(i))
                    .append(" zł\n");
        }
        System.out.println(result.toString());
    }

}
