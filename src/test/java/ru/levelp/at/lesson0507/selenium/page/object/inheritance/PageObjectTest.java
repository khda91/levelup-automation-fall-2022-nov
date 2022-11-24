package ru.levelp.at.lesson0507.selenium.page.object.inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0507.page.object.inheritance.IndexPage;
import ru.levelp.at.lesson0507.page.object.inheritance.LoginRegistrationPage;
import ru.levelp.at.lesson0507.selenium.page.object.BaseSeleniumTest;

class PageObjectTest extends BaseSeleniumTest {

    @Test
    void registrationTest() {
        String name = faker.funnyName().name();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(driver);
        IndexPage indexPage = new IndexPage(driver);

        loginRegistrationPage.open();

        loginRegistrationPage.enterNameToNameTextField(name);
        loginRegistrationPage.enterEmailToEmailTextField(email);
        loginRegistrationPage.enterPasswordToPasswordTextField(password);
        loginRegistrationPage.clickRegisterButton();

        String actualUserName = indexPage.getUsernameFromDropdown();
        assertThat(actualUserName).isEqualToIgnoringCase(name);
    }

    @Test
    void negativeRegistrationTest() {
        String name = faker.funnyName().name();
        String email = faker.internet().domainName();
        String password = faker.internet().password();

        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(driver);

        loginRegistrationPage.open();
        loginRegistrationPage.enterNameToNameTextField(name);
        loginRegistrationPage.enterEmailToEmailTextField(email);
        loginRegistrationPage.enterPasswordToPasswordTextField(password);
        loginRegistrationPage.clickRegisterButton();
        String actualErrorMessage = loginRegistrationPage.getErrorMessageText();

        assertThat(actualErrorMessage).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
