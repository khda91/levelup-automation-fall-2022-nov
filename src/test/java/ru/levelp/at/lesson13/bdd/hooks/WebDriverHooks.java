package ru.levelp.at.lesson13.bdd.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;

public class WebDriverHooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        TestContext.getInstance().putObject("driver", driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.clear();
    }


}
