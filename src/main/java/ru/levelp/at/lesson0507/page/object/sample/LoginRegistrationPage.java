package ru.levelp.at.lesson0507.page.object.sample;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginRegistrationPage {

    private static final String USER_BUG_RED_URL = "http://users.bugred.ru/user/login/index.html";

    private final WebDriver driver;

    private final WebDriverWait wait;

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
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(USER_BUG_RED_URL);
    }

    public void enterNameToNameTextField(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameTextField)).sendKeys(name);
    }

    public void enterEmailToEmailTextField(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailTextField)).sendKeys(email);
    }

    public void enterPasswordToPasswordTextField(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public String getErrorMessageText() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLabel)).getText();
    }
}
