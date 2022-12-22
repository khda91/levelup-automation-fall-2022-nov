package ru.levelp.at.lesson12.design.patterns.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverFactory {

    private static  final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    private WebDriverFactory() {
    }

    public static WebDriver create(String browserName) {
        WebDriver driver = null;

        if (CHROME.equalsIgnoreCase(browserName)) {
            driver = createChromeDriver();
        } else if (FIREFOX.equalsIgnoreCase(browserName)) {
            driver = createFirefoxDriver();
        }

        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }
}
