package ru.levelp.at.lesson12.design.patterns.factory;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.utils.SleepUtils;

class WebDriverFactoryTest {

    static Stream<Arguments> browserNameDataProvider() {
        return Stream.of(
            Arguments.of("chrome"),
            Arguments.of("firefox")
        );
    }

    @ParameterizedTest
    @MethodSource("browserNameDataProvider")
    void test(String browserName) {
        WebDriver driver = WebDriverFactory.create(browserName);
        SleepUtils.sleep(1500);
        driver.quit();
    }


    @ParameterizedTest
    @MethodSource("browserNameDataProvider")
    void testWithSingleton(String browserName) {
        System.setProperty("browser.name", browserName);
        WebDriver driver = WebDriverSingleton.get();
        SleepUtils.sleep(1500);
        driver.quit();
    }
}
