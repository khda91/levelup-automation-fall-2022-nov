package ru.levelp.at.lesson0304.unit;

public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}
