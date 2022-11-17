package ru.levelp.at.lesson0304.unit.parametrized;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.unit.ListManipulator;

public class ParametrizedTestExampleTest {

    private ListManipulator manipulator;

    @DataProvider
    public static Object[][] exampleDataProvider() {
        return new Object[][] {
            {new ArrayList<String>() {
                {
                    add("sam");
                    add(null);
                    add("vaN");
                    add(null);
                    add("SSS");
                }
            }, "s", List.of("am", "vaN", "")},
            {List.of("sam", "vaN", "SSS"), "s", List.of("am", "vaN", "")},
            {List.of("aaa", "qwqwqwAsd", "AbbA"), "a", List.of("", "qwqwqwsd", "bb")}
        };
    }

    @DataProvider(name = "Empty List Data Provider")
    public static Object[][] exampleWithNameDataProvider() {
        return new Object[][] {
            {Collections.emptyList(), "s", Collections.emptyList()}
        };
    }

    @BeforeMethod
    public void setUp() {
        manipulator = new ListManipulator();
    }

    @Test(dataProvider = "exampleDataProvider")
    public void example(List<String> input, String letter, List<String> expected) {
        List<String> actual = manipulator.manipulate(input, letter);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test(dataProvider = "Empty List Data Provider")
    public void exampleWithName(List<String> input, String letter, List<String> expected) {
        List<String> actual = manipulator.manipulate(input, letter);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
