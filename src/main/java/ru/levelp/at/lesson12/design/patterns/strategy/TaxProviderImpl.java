package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;

public class TaxProviderImpl implements TaxProvider {

    private final TaxCalculator taxCalculator;

    public TaxProviderImpl(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public BigDecimal calculate(BigDecimal yearIncome) {
        return taxCalculator.calculate(yearIncome);
    }
}
