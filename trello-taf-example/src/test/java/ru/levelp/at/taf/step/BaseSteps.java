package ru.levelp.at.taf.step;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.page.TrelloBoardPage;
import ru.levelp.at.taf.page.TrelloBoardsPage;
import ru.levelp.at.taf.page.TrelloLoginPage;
import ru.levelp.at.taf.page.TrelloMainPage;

public abstract class BaseSteps {

    protected WebDriver driver;

    protected TrelloMainPage mainPage;
    protected TrelloLoginPage loginPage;
    protected TrelloBoardsPage boardsPage;
    protected TrelloBoardPage boardPage;

    protected BaseSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = new TrelloMainPage(driver);
        loginPage = new TrelloLoginPage(driver);
        boardsPage = new TrelloBoardsPage(driver);
        boardPage = new TrelloBoardPage(driver);
    }
}
