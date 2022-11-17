package ru.levelp.at.lesson0304.unit;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListManipulatorNegativeTest {

    private ListManipulator manipulator;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
        manipulator = new ListManipulator();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void manipulateListNullTest() {
        System.out.println("manipulateListNullTest");
        manipulator.manipulate(null, "s");
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "Список не может быть null.")
    public void manipulateListNullWithMessageTest() {
        System.out.println("manipulateListNullWithMessageTest");
        manipulator.manipulate(null, "s");
    }

    @Test
    public void manipulateLetterNullTest() {
        System.out.println("manipulateLetterNullTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void manipulateLetterNullWithMessageTest() {
        System.out.println("manipulateLetterNullWithMessageTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Буква не может быть null.");
    }

    @Test
    public void manipulateWithEmptyList() {
        System.out.println("manipulateLetterNullWithMessageTest");
        List<String> actual = manipulator.manipulate(Collections.emptyList(), "s");

        Assertions.assertThat(actual).isEmpty();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
        manipulator = null;
    }
}
