package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinancialArithmetic {
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private static final int DEFAULT_SCALE = 2;
    private static final int PRECISE_SCALE = 17;

    private FinancialArithmetic() {
    }

    public static BigDecimal addAll(BigDecimal[] summands) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal summand : summands) {
            sum = sum.add(summand).setScale(DEFAULT_SCALE, ROUNDING_MODE);
        }
        return sum;
    }

    public static BigDecimal add(BigDecimal summand1, BigDecimal summand2) {
        return summand1.add(summand2)
                .setScale(DEFAULT_SCALE, ROUNDING_MODE);
    }

    public static BigDecimal subtract(BigDecimal minuend, BigDecimal subtrahend) {
        return minuend.subtract(subtrahend)
                .setScale(DEFAULT_SCALE, ROUNDING_MODE);
    }

    public static BigDecimal multiply(BigDecimal multiplicand, BigDecimal multiplier) {
        return multiplicand.multiply(multiplier)
                .setScale(DEFAULT_SCALE, ROUNDING_MODE);
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        return dividend.divide(divisor, PRECISE_SCALE, ROUNDING_MODE);
    }

}
