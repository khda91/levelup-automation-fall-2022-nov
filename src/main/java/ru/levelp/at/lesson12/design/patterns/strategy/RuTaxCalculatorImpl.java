package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RuTaxCalculatorImpl implements TaxCalculator {

    private static final BigDecimal USUAL_TAX_RATE = BigDecimal.valueOf(0.13);
    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.15);

    private static final BigDecimal TAX_RATE_AMOUNT = BigDecimal.valueOf(2500000L);

    @Override
    public BigDecimal calculate(BigDecimal yearIncome) {
        if (TAX_RATE_AMOUNT.compareTo(yearIncome) < 0) {
            return yearIncome.multiply(TAX_RATE).setScale(2, RoundingMode.HALF_UP);
        }
        return yearIncome.multiply(USUAL_TAX_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
