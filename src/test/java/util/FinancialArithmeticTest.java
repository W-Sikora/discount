package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static util.FinancialArithmetic.*;

class FinancialArithmeticTest {

    @Test
    @DisplayName("should add all summands")
    void shouldAddAllSummands() {
        BigDecimal[] values = {
                new BigDecimal("12.34"),
                new BigDecimal("56.78"),
                new BigDecimal("90.00")
        };
        assertEquals(new BigDecimal("159.12"), addAll(values));
    }

    @Test
    @DisplayName("should add two summands")
    void shouldAddTwoSummands() {
        assertEquals(new BigDecimal("1.01"), add(new BigDecimal("1.0043"), new BigDecimal("0.0057")));
    }

    @Test
    @DisplayName("should subtract")
    void shouldSubtract() {
        assertEquals(BigDecimal.ONE, subtract(new BigDecimal("1.01"), BigDecimal.ONE));
    }

    @Test
    @DisplayName("should multiply")
    void shouldMultiply() {
        assertEquals(new BigDecimal("1.00") , multiply(new BigDecimal("0.3333"), new BigDecimal("3.00")));
    }

    @Test
    @DisplayName("should divide")
    void shouldDivide() {
        assertEquals(new BigDecimal("0.37036666666666667"), divide(new BigDecimal("333.33"), new BigDecimal("900.00")));
    }

}
