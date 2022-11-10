package ru.levelp.at.lesson02.git;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("===== Sum =====");
        System.out.printf("%d + %d = %d%n", 2, 2, calculator.sum(2, 2));
        System.out.printf("%d + %d = %d%n", 5, 10, calculator.sum(5, 10));
        System.out.println("==========");
        System.out.println();
    }

}
