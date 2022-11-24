package ru.levelp.at.lesson0507.page.object.inheritance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginRegistrationPage extends UserBugRedBasePage {

    private static final String LOGIN_REGISTRATION_PAGE_URL = "/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement nameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[contains(@action, 'register')]/p")
    private WebElement errorMessageLabel;

    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open(LOGIN_REGISTRATION_PAGE_URL);
    }

    public void enterNameToNameTextField(String name) {
        sendKeysToElement(nameTextField, name);
    }

    public void enterEmailToEmailTextField(String email) {
        sendKeysToElement(emailTextField, email);
    }

    public void enterPasswordToPasswordTextField(String password) {
        sendKeysToElement(passwordTextField, password);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public String getErrorMessageText() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLabel)).getText();
    }
}
