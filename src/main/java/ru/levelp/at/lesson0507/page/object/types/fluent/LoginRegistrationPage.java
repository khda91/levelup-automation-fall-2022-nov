package ru.levelp.at.lesson0507.page.object.types.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginRegistrationPage extends UserBugRedBasePage<LoginRegistrationPage> {

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
    public LoginRegistrationPage open() {
        open(LOGIN_REGISTRATION_PAGE_URL);
        return this;
    }

    public LoginRegistrationPage enterNameToNameTextField(String name) {
        sendKeysToElement(nameTextField, name);
        return this;
    }

    public LoginRegistrationPage enterEmailToEmailTextField(String email) {
        sendKeysToElement(emailTextField, email);
        return this;
    }

    public LoginRegistrationPage enterPasswordToPasswordTextField(String password) {
        sendKeysToElement(passwordTextField, password);
        return this;
    }

    public IndexPage clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return new IndexPage(driver);
    }

    public UserBugRedBasePage clickRegisterButtonWithAbstractPage() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        if (wait.until(ExpectedConditions.invisibilityOf(registerButton))) {
            return new IndexPage(driver);
        } else {
            return this;
        }
    }

    public IndexPage successClickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return new IndexPage(driver);
    }

    public LoginRegistrationPage failClickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return this;
    }

    public String getErrorMessageText() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLabel)).getText();
    }
}
