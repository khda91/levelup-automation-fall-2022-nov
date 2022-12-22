package ru.levelp.at.lesson12.design.patterns.factory;

import org.openqa.selenium.WebDriver;

public final class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {

    }

    public static WebDriver get() {
        if (driver == null) {
            String browserName = System.getProperty("browser.name");
            driver = WebDriverFactory.create(browserName);
        }

        return driver;
    }

    public static void close() {
        driver.quit();
        driver = null;
    }
}
