package ru.levelp.at.lesson0507.page.object.types.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends UserBugRedBasePage<IndexPage> {

    @FindBy(xpath = "//li[@id='fat-menu']/a[@class='dropdown-toggle']")
    private WebElement usernameDropdown;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IndexPage open() {
        open("/");
        return this;
    }

    public String getUsernameFromDropdown() {
        return usernameDropdown.getText();
    }

}
