package ru.levelp.at.lesson0507.page.object.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

    @FindBy(xpath = "//li[@id='fat-menu']/a[@class='dropdown-toggle']")
    private WebElement usernameDropdown;

    public String getUsernameFromDropdown() {
        return usernameDropdown.getText();
    }
}
