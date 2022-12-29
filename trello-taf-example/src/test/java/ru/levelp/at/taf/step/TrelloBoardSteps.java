package ru.levelp.at.taf.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.page.TrelloBoardsPage.MenuItem;
import ru.levelp.at.taf.page.component.TrelloBoardCardComponent;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrelloBoardSteps extends BaseSteps {

    public TrelloBoardSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Создаём доску")
    public void createBoard(final String boardName) {
        boardsPage.clickCreateButton();
        boardsPage.selectMenu(MenuItem.CREATE_BOARD);
        boardsPage.sendKeysToBoardTitleTextField(boardName);
        boardsPage.clickCreateBoardButton();
    }

    @Step("Проверка, что имя созданной доски совпадает с оригинальным значением")
    public void assertBoardTitle(final String expectedBoardName) {
        var actualBoardTitle = boardPage.getTitle();

        assertThat(actualBoardTitle).as("Board has incorrect name").isEqualTo(expectedBoardName);
    }

    @Step("Удаляем доску")
    public void deleteBoard() {
        boardPage.clickShowMenuButton();
        boardPage.clickMoreButton();
        boardPage.clickCloseBoardButton();
        boardPage.clickConfirmationCloseBoardButton();
        boardPage.clickCloseBoardDeleteBoardButton();
        boardPage.clickCloseBoardDeleteConfirmBoardButton();
    }

    public List<TrelloBoardCardComponent> getBoards() {
        return boardsPage.getBoards();
    }

    @Step("Открываем доску {boardName}")
    public void openBoard(final String boardName) {
        boardsPage.openBoard(boardName);
    }
}
