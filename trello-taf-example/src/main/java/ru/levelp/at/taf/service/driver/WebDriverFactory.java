package ru.levelp.at.taf.service.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.taf.exception.UnsupportedBrowserException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

    private static final String CHROME = "chrome";

    public static WebDriver createDriver(final String browserName) {
        WebDriver driver;
        if (CHROME.equalsIgnoreCase(browserName)) {
            driver = createChromeDriver();
        } else {
            throw new UnsupportedBrowserException(browserName);
        }

        return driver;
    }

    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }
}
