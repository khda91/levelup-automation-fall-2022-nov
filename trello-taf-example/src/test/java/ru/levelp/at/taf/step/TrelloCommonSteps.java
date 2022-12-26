package ru.levelp.at.taf.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TrelloCommonSteps extends BaseSteps {

    public TrelloCommonSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Окрыть Trello App")
    public void openTrello() {
        mainPage.open();
    }
}
