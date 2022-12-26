package ru.levelp.at.taf.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.taf.service.driver.WebDriverSingleton;
import ru.levelp.at.taf.step.TrelloBoardSteps;
import ru.levelp.at.taf.step.TrelloCommonSteps;
import ru.levelp.at.taf.step.TrelloLoginSteps;

public abstract class BaseTest {

    protected static final Faker FAKER = new Faker();

    protected TrelloCommonSteps commonSteps;
    protected TrelloLoginSteps loginSteps;
    protected TrelloBoardSteps boardSteps;

    @BeforeEach
    void setUp() {
        var driver = WebDriverSingleton.getDriver();

        commonSteps = new TrelloCommonSteps(driver);
        loginSteps = new TrelloLoginSteps(driver);
        boardSteps = new TrelloBoardSteps(driver);
    }

    @AfterEach
    void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
