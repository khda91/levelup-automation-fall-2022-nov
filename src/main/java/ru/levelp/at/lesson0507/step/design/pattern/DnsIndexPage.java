package ru.levelp.at.lesson0507.step.design.pattern;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DnsIndexPage extends DnsBasePage {

    @FindBy(css = "div.menu-desktop__root a.ui-link")
    private List<WebElement> menuItems;

    public DnsIndexPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Окрыть страницу")
    public void open() {
        open("/");
    }

    @Step("Открываем категорию меню: {categoryName}")
    public void openMenuCategory(final String categoryName) {
        for (WebElement menuItem : menuItems) {
            String menuItemText = wait.until(ExpectedConditions.visibilityOf(menuItem)).getText();
            if (categoryName.equalsIgnoreCase(menuItemText)) {
                wait.until(ExpectedConditions.elementToBeClickable(menuItem)).click();
                break;
            }
        }
    }
}
