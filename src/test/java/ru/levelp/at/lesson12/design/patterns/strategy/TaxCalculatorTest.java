package ru.levelp.at.lesson12.design.patterns.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TaxCalculatorTest {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of(new RuTaxCalculatorImpl(), BigDecimal.valueOf(2499999L), BigDecimal.valueOf(324999.87)),
            Arguments.of(new RuTaxCalculatorImpl(), BigDecimal.valueOf(2500000L),
                BigDecimal.valueOf(325000.00).setScale(2)),
            Arguments.of(new TuTaxCalculatorImpl(), BigDecimal.valueOf(9999L), BigDecimal.valueOf(1499.85)),
            Arguments.of(new TuTaxCalculatorImpl(), BigDecimal.valueOf(65000L),
                BigDecimal.valueOf(19500.00).setScale(2)),
            Arguments.of(new TuTaxCalculatorImpl(), BigDecimal.valueOf(150000L),
                BigDecimal.valueOf(60000.0).setScale(2))
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void test(TaxCalculator taxCalculator, BigDecimal income, BigDecimal expectedTax) {
        var taxCalc = new TaxProviderImpl(taxCalculator);
        var taxAmount = taxCalc.calculate(income);
        assertThat(taxAmount).isEqualTo(expectedTax);
    }

    void taxTest(String country, BigDecimal income) {
        TaxProvider taxProvider = null;

        if (country.equals("ru")) {
            taxProvider = new TaxProviderImpl(new RuTaxCalculatorImpl());
        } else if (country.equals("tu")) {
            taxProvider = new TaxProviderImpl(new TuTaxCalculatorImpl());
        }

        BigDecimal taxAmount = taxProvider.calculate(income);
    }
}
