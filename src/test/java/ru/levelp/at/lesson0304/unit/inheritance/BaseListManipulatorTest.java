package ru.levelp.at.lesson0304.unit.inheritance;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ru.levelp.at.lesson0304.unit.ListManipulator;

public abstract class BaseListManipulatorTest {

    protected ListManipulator manipulator;

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
        manipulator = new ListManipulator();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
        manipulator = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
        manipulator = null;
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }
}
