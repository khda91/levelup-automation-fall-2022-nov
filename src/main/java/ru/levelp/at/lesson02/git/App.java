package ru.levelp.at.lesson02.git;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("===== Sum =====");
        System.out.printf("%d + %d = %d%n", 2, 2, calculator.sum(2, 2));
        System.out.printf("%d + %d = %d%n", 5, 10, calculator.sum(5, 10));
        System.out.println("==========");
        System.out.println();

        System.out.println("===== Subtract =====");
        System.out.printf("%d - %d = %d%n", 2, 2, calculator.subtract(2, 2));
        System.out.printf("%d - %d = %d%n", 5, 10, calculator.subtract(5, 10));
        System.out.println("==========");
        System.out.println();

        System.out.println("===== Multiply =====");
        System.out.printf("%d * %d = %d%n", 2, 2, calculator.multiply(2, 2));
        System.out.printf("%d * %d = %d%n", 5, 10, calculator.multiply(5, 10));
        System.out.println("==========");
        System.out.println();

        System.out.println("===== Divide =====");
        System.out.printf("%.2f / %.2f = %.2f%n", 2, 2, calculator.divide(2D, 2D));
        System.out.printf("%.2f / %.2f = %.2f%n", 5, 10, calculator.divide(5D, 10D));
        System.out.println("==========");
        System.out.println();
    }

}
