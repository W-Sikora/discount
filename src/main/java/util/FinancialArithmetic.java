package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinancialArithmetic {
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private static final int DEFAULT_SCALE = 2;
    private static final int PRECISE_SCALE = 17;

    private FinancialArithmetic() {
    }

    public static BigDecimal addAll(BigDecimal[] values) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal value : values) {
            sum = sum.add(value).setScale(DEFAULT_SCALE, ROUNDING_MODE);
        }
        return sum;
    }

    public static BigDecimal add(BigDecimal value1, BigDecimal value2) {
        return value1.add(value2)
                .setScale(DEFAULT_SCALE, ROUNDING_MODE);
    }

    public static BigDecimal subtract(BigDecimal value1, BigDecimal value2) {
        return value1.subtract(value2)
                .setScale(DEFAULT_SCALE, ROUNDING_MODE);
    }

    public static BigDecimal multiply(BigDecimal value1, BigDecimal value2) {
        return value1.multiply(value2)
                .setScale(DEFAULT_SCALE, ROUNDING_MODE);
    }

    public static BigDecimal divide(BigDecimal value1, BigDecimal value2) {
        return value1.divide(value2, PRECISE_SCALE, ROUNDING_MODE);
    }

}
