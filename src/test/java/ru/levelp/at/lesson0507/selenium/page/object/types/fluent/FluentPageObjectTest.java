package ru.levelp.at.lesson0507.selenium.page.object.types.fluent;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0507.page.object.types.fluent.IndexPage;
import ru.levelp.at.lesson0507.page.object.types.fluent.LoginRegistrationPage;
import ru.levelp.at.lesson0507.page.object.types.fluent.UserBugRedBasePage;
import ru.levelp.at.lesson0507.selenium.page.object.BaseSeleniumTest;

class FluentPageObjectTest extends BaseSeleniumTest {

    @Test
    void registrationTest() {
        String name = faker.funnyName().name();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        IndexPage indexPage = new LoginRegistrationPage(driver)
            .open()
            .enterNameToNameTextField(name)
            .enterEmailToEmailTextField(email)
            .enterPasswordToPasswordTextField(password)
            .clickRegisterButton();

        String actualUserName = indexPage.getUsernameFromDropdown();
        assertThat(actualUserName).isEqualToIgnoringCase(name);
    }

    @Test
    void successRegistrationTest() {
        String name = faker.funnyName().name();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        IndexPage indexPage = new LoginRegistrationPage(driver)
            .open()
            .enterNameToNameTextField(name)
            .enterEmailToEmailTextField(email)
            .enterPasswordToPasswordTextField(password)
            .successClickRegisterButton();

        String actualUserName = indexPage.getUsernameFromDropdown();
        assertThat(actualUserName).isEqualToIgnoringCase(name);
    }

    @Test
    void negativeRegistrationTest() {
        String name = faker.funnyName().name();
        String email = faker.internet().domainName();
        String password = faker.internet().password();

        String actualErrorMessage = new LoginRegistrationPage(driver)
            .open()
            .enterNameToNameTextField(name)
            .enterEmailToEmailTextField(email)
            .enterPasswordToPasswordTextField(password)
            .failClickRegisterButton()
            .getErrorMessageText();

        assertThat(actualErrorMessage).isEqualToIgnoringCase("register_not_correct_field (email)");
    }

    @Test
    void negativeRegistrationWithAbstractBasePageTest() {
        String name = faker.funnyName().name();
        String email = faker.internet().domainName();
        String password = faker.internet().password();

        UserBugRedBasePage basePage = new LoginRegistrationPage(driver)
            .open()
            .enterNameToNameTextField(name)
            .enterEmailToEmailTextField(email)
            .enterPasswordToPasswordTextField(password)
            .clickRegisterButtonWithAbstractPage();

        LoginRegistrationPage indexPage = null;
        if (basePage instanceof LoginRegistrationPage) {
            indexPage = (LoginRegistrationPage) basePage;
        }

        String actualErrorMessage = indexPage.getErrorMessageText();

        assertThat(actualErrorMessage).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
