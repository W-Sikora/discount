package util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FinancialArithmeticTest {

    @Test
    void addAll() {
        BigDecimal[] values = {
                new BigDecimal("12.34"),
                new BigDecimal("56.78"),
                new BigDecimal("90.00")
        };
        assertEquals(new BigDecimal("159.12"), FinancialArithmetic.addAll(values));
    }

}
