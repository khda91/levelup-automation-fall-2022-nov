package ru.levelp.at.lesson0304.unit.groups;

import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.NEGATIVE_GROUP;
import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.POSITIVE_GROUP;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import ru.levelp.at.lesson0304.unit.ListManipulator;

public abstract class BaseListManipulatorTest {

    protected ListManipulator manipulator;

    @BeforeGroups(groups = {"positive"})
    public void positiveBeforeGroup() {
        System.out.println("positiveBeforeGroup");
    }

    @BeforeGroups(groups = {"negative"})
    public void negativeBeforeGroup() {
        System.out.println("negativeBeforeGroup");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("beforeMethod");
        manipulator = new ListManipulator();
    }

    // @AfterMethod(groups = {"positive", "negative"})
    @AfterMethod(groups = {POSITIVE_GROUP, NEGATIVE_GROUP})
    public void afterMethod() {
        System.out.println("afterMethod");
        manipulator = null;
    }

    @AfterGroups(groups = {"positive"})
    public void positiveAfterGroup() {
        System.out.println("positiveAfterGroup");
    }

    @AfterGroups(groups = {"negative"})
    public void negativeAfterGroup() {
        System.out.println("negativeAfterGroup");
    }
}
