package ru.levelp.at.lesson0304.unit.parametrized;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.levelp.at.lesson0304.unit.Calculator;
import ru.levelp.at.lesson0304.unit.CalculatorImpl;

class CalculatorTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ru/levelp/at/lesson0304/unit/calculator_sum.csv", delimiterString = ";")
    void sumTest(int a, int b, int expected) {
        Calculator calculator = new CalculatorImpl();
        int sum = calculator.sum(a, b);

        assertThat(sum).isEqualTo(expected);
    }
}
