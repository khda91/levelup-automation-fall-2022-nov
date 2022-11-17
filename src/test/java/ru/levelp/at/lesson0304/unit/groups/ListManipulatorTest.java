package ru.levelp.at.lesson0304.unit.groups;

import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.NEGATIVE_GROUP;
import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.POSITIVE_GROUP;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ListManipulatorTest extends BaseListManipulatorTest {

    //    @Test(groups = {"positive"})
    @Test(groups = {POSITIVE_GROUP})
    public void manipulateOneMoreTest() {
        System.out.println("manipulateOneMoreTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");
        List<String> expected = List.of("end", "aM", "cloe", "rOck", "lk");
        List<String> actual = manipulator.manipulate(input, "s");

        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    //    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"negative"})
    @Test(expectedExceptions = IllegalArgumentException.class, groups = {NEGATIVE_GROUP})
    public void manipulateListNullTest() {
        System.out.println("manipulateListNullTest");
        manipulator.manipulate(null, "s");
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "Список не может быть null.", groups = {"negative"})
    public void manipulateListNullWithMessageTest() {
        System.out.println("manipulateListNullWithMessageTest");
        manipulator.manipulate(null, "s");
    }

    @Test(groups = {"negative"})
    public void manipulateLetterNullTest() {
        System.out.println("manipulateLetterNullTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class);
    }
}
