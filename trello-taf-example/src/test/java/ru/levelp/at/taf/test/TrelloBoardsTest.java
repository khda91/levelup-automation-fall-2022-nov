package ru.levelp.at.taf.test;

import org.junit.jupiter.api.Test;
import ru.levelp.at.taf.configuration.WebAppConfig;

import static org.assertj.core.api.Assertions.assertThat;

class TrelloBoardsTest extends BaseTest {

    @Test
    void createNewBoard() {
        var username = WebAppConfig.getInstance().username();
        var password = WebAppConfig.getInstance().password();

        var boardName = FAKER.funnyName().name();

        commonSteps.openTrello();

        loginSteps.login(username, password);

        boardSteps.createBoard(boardName);

        boardSteps.assertBoardTitle(boardName);
    }

    @Test
    void deleteBoard() {
        var username = WebAppConfig.getInstance().username();
        var password = WebAppConfig.getInstance().password();

        var boardName = FAKER.funnyName().name();

        commonSteps.openTrello();

        loginSteps.login(username, password);

        var initialBoardAmount = boardSteps.getBoards();

        boardSteps.deleteBoard();

        var actualBoardAmount = boardSteps.getBoards();

        assertThat(actualBoardAmount).isEqualTo(initialBoardAmount - 1);
    }
}
