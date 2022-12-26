package ru.levelp.at;

import io.qameta.allure.AllureId;

import static ru.levelp.at.SomeClass.someMethod;

public class Test {


    @org.junit.jupiter.api.Test
    @AllureId("1234")
    public void test1234() {
        someMethod(new Object());
    }

    @org.junit.jupiter.api.Test
    @AllureId("4321")
    public void test4321() {
        someMethod(new Object());
    }

    @org.junit.jupiter.api.Test
    @AllureId("2314")
    public void test2314() {
        someMethod(new Object());
    }
}
