package ru.levelp.at.lesson02.git;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int pow(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Не умеем считать отрицательные степени!!!");
        }

        if (b == 0) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        return result;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Нельзя делить на 0!!!!");
        }
        return a / b;
    }
}
