package ru.levelp.at.taf.service.driver;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            var browserName = System.getProperty("browser.name");
            driver = WebDriverFactory.createDriver(browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
