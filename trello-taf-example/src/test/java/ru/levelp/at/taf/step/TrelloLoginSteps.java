package ru.levelp.at.taf.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TrelloLoginSteps extends BaseSteps {

    public TrelloLoginSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Захожу под пользователем")
    public void login(final String username, final String password) {
        mainPage.clickLoginButton();

        loginPage.sendKeysToUsernameTextField(username);
        loginPage.clickContinueButton();
        loginPage.sendKeysToPasswordTextField(password);
        loginPage.clickLoginButton();
    }
}
