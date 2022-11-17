package ru.levelp.at.lesson0304.unit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgStandardAssertionTest {

    @Test
    public void test() {
        Assert.assertEquals(2 + 2, 4);
    }
}
