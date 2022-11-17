package ru.levelp.at.lesson0304.unit.parametrized;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.unit.Calculator;
import ru.levelp.at.lesson0304.unit.CalculatorImpl;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new CalculatorImpl();
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "calculatorSumDataProvider")
    public void sumTest(int a, int b, int expected) {
        int actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "Multiply Data")
    public void multiplyTest(int a, int b, int expected) {
        int actual = calculator.multiply(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
