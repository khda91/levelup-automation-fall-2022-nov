package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TuTaxCalculatorImpl implements TaxCalculator {

    private static final BigDecimal TAX_RATE_INCOME_LESS_10000 = BigDecimal.valueOf(0.15);
    private static final BigDecimal TAX_RATE_INCOME_MORE_10000_LESS_150000 = BigDecimal.valueOf(0.30);
    private static final BigDecimal TAX_RATE_INCOME_MORE_150000 = BigDecimal.valueOf(0.40);

    private static final BigDecimal INCOME_10000 = BigDecimal.valueOf(10000L);
    private static final BigDecimal INCOME_150000 = BigDecimal.valueOf(150000L);

    @Override
    public BigDecimal calculate(BigDecimal yearIncome) {
        if (INCOME_10000.compareTo(yearIncome) > 0) {
            return yearIncome.multiply(TAX_RATE_INCOME_LESS_10000)
                                             .setScale(2, RoundingMode.HALF_UP);
        } else if (INCOME_10000.compareTo(yearIncome) < 1
            && INCOME_150000.compareTo(yearIncome) > 0) {
            return yearIncome.multiply(TAX_RATE_INCOME_MORE_10000_LESS_150000)
                                             .setScale(2, RoundingMode.HALF_UP);
        }

        return yearIncome.multiply(TAX_RATE_INCOME_MORE_150000)
                                         .setScale(2, RoundingMode.HALF_UP);
    }
}
